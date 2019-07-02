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
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode node) {
        // bottom to up, find one node which is not balanced, return -1 all the way up
        if (node == null) return 0;
        int left = depth(node.left);
        if (left == -1) return -1;
        int right = depth(node.right);
        if (right == -1) return -1;
        int max = Math.max(left, right) + 1;
        int diff = Math.abs(left - right);
        if (diff > 1) return -1;
        return max;
    }
}
