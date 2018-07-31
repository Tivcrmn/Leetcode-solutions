class Solution {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int res = root.val;
        if (root.left != null) {
            res += rob(root.left.left);
            res += rob(root.left.right);
        }
        if (root.right != null) {
            res += rob(root.right.left);
            res += rob(root.right.right);
        }
        return Math.max(rob(root.left) + rob(root.right), res);
    }
}
