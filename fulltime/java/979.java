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
    int moves;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return moves;
    }

    private int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int leftDiff = left[1] - left[0];
        int rightDiff = right[1] - right[0];
        moves += Math.abs(leftDiff) + Math.abs(rightDiff);
        return new int[]{left[0] + right[0] + 1, left[1] + right[1] + root.val};
    }
}
