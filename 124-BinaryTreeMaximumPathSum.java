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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] max = new int[]{Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    private int helper(TreeNode root, int[] max) {
        int leftMax = root.left == null ? 0 : Math.max(helper(root.left, max), 0);
        int rightMax = root.right == null ? 0 : Math.max(helper(root.right, max), 0);
        max[0] = Math.max(root.val + leftMax + rightMax, max[0]);
        return root.val + Math.max(leftMax, rightMax);
    }
}
