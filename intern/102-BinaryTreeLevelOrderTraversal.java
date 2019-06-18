class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<List<Integer>>();
        }
        TreeNode lastNode = root;
        TreeNode nextLastNode = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
        LinkedList<Integer> sublist = new LinkedList<Integer>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode x = queue.poll();
            sublist.add(x.val);
            if (x.left != null) {
                queue.add(x.left);
                nextLastNode = x.left;
            }
            if (x.right != null) {
                queue.add(x.right);
                nextLastNode = x.right;
            }
            if (x == lastNode) {
                list.add(sublist);
                sublist = new LinkedList<Integer>();
                lastNode = nextLastNode;
            }
        }
        return list;
    }
}
