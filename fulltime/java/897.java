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
    TreeNode dummy = new TreeNode(-1);
    TreeNode cur = dummy;
    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return dummy.right;
    }

    private void helper(TreeNode node) {
        // recursively
        if (node == null) return;
        helper(node.left);
        node.left = null;
        cur.right = node;
        cur = cur.right;
        helper(node.right);
    }
}
