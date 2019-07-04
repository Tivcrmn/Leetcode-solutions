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
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder,
                            int[] inorder,
                            int ps,
                            int pe,
                            int is,
                            int ie) {
        if (ps > pe) return null;
        if (ps == pe) return new TreeNode(preorder[ps]);
        TreeNode node = new TreeNode(preorder[ps]);
        int index = is;
        while (inorder[index] != preorder[ps]) index++;
        int leftSubtreeLen = index - is;
        node.left = helper(preorder, inorder, ps + 1, ps + leftSubtreeLen, is, index - 1);
        node.right = helper(preorder, inorder, ps + leftSubtreeLen + 1, pe, index + 1, ie);
        return node;
    }
}
