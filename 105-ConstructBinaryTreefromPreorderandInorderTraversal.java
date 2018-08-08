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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) return null;
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int pre, int is, int ie) {
        if (pre >= preorder.length || is > ie) return null;
        int i = 0;
        while (inorder[i] != preorder[pre]) i++;
        TreeNode cur = new TreeNode(preorder[pre]);
        cur.left = helper(preorder, inorder, pre + 1, is, i - 1);
        cur.right = helper(preorder, inorder, pre + i - is + 1, i + 1, ie);
        return cur;
    }
}
