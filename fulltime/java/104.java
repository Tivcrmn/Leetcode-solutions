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
    public int maxDepth(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        int maxLocal = Math.max(left, right) + 1;
        max = Math.max(max, maxLocal);
        return maxLocal;
    }
}
