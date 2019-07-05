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
    class XNode {
        int x;
        TreeNode node;
        public XNode (int x, TreeNode node) {
            this.x = x;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        if (root == null) return 0;
        Queue<XNode> queue = new LinkedList<>();
        queue.offer(new XNode(0, root));
        while (!queue.isEmpty()) {
            int size = queue.size();
            XNode first = null;
            XNode last = null;
            for (int i = 0; i < size; i++) {
                XNode xnode = queue.poll();
                TreeNode node = xnode.node;
                int x = xnode.x;
                if (i == 0) first = xnode;
                if (i == size - 1) last = xnode;
                if (node.left != null) {
                    queue.offer(new XNode(2 * x, node.left));
                }
                if (node.right != null) {
                    queue.offer(new XNode(2 * x + 1, node.right));
                }
            }
            max = Math.max(max, last.x - first.x + 1);
        }
        return max;
    }
}
