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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode node) {
        if (node == null) return -1;
        int left = Math.max(helper(node.left), 0);
        int right = Math.max(helper(node.right), 0);
        int localMax = left + right;
        max = Math.max(localMax, max);
        return Math.max(left , right) + 1;
    }
}
