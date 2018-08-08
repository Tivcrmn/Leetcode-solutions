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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || postorder.length != inorder.length) return null;
        return helper(postorder, inorder, inorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int[] inorder, int post, int is, int ie) {
        if (post < 0 || is > ie) return null;
        int i = 0;
        while (inorder[i] != postorder[post]) i++;
        TreeNode cur = new TreeNode(postorder[post]);
        cur.left = helper(postorder, inorder, post - ie + i - 1, is, i - 1);
        cur.right = helper(postorder, inorder, post - 1, i + 1, ie);
        return cur;
    }
}
