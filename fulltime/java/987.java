/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Node {
        int x;
        int y;
        TreeNode node;
        public Node(int x, int y, TreeNode node) {
            this.x = x;
            this.y = y;
            this.node = node;
        }
    }

    Comparator<Node> compareByVal = new Comparator<Node>() {
        @Override
        public int compare(Node n1, Node n2) {
            if (n1.y > n2.y) {
                return -1;
            } else if (n1.y < n2.y) {
                return 1;
            } else if (n1.node.val < n2.node.val) {
                return -1;
            } else {
                return 1;
            }
        }
    };

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        LinkedList<List<Node>> verticals = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        int beginXIndex = 0;
        queue.offer(new Node(0, 0, root));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                int x = n.x;
                int y = n.y;
                TreeNode node = n.node;
                List<Node> vertical = null;
                if (x < beginXIndex) {
                    beginXIndex -= 1;
                    vertical = new ArrayList<>();
                    verticals.addFirst(vertical);
                } else if (x >= verticals.size() + beginXIndex) {
                    vertical = new ArrayList<>();
                    verticals.add(vertical);
                } else {
                    int index = x - beginXIndex;
                    vertical = verticals.get(index);
                }
                if (node.left != null) {
                    queue.offer(new Node(x - 1, y - 1, node.left));
                }
                if (node.right != null) {
                    queue.offer(new Node(x + 1, y - 1,node.right));
                }
                vertical.add(n);
            }
        }
        for (List<Node> vertical : verticals) {
            Collections.sort(vertical, compareByVal);
            List<Integer> list = new ArrayList<>();
            for (Node n : vertical) {
                list.add(n.node.val);
            }
            res.add(list);
        }
        return res;
    }
}
