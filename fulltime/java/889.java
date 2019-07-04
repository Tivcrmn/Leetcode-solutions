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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    private TreeNode helper(int[] pre,
                            int[] post,
                            int preS,
                            int preE,
                            int postS,
                            int postE) {
        if (preS > preE) return null;
        if (preS == preE) return new TreeNode(pre[preS]);
        TreeNode node = new TreeNode(pre[preS]);
        int index = postS;
        while (pre[preS + 1] != post[index]) index++;
        int leftSubtreeLen = index - postS + 1;
        node.left = helper(pre, post, preS + 1, preS + leftSubtreeLen, postS, index);
        node.right = helper(pre, post, preS + leftSubtreeLen + 1, preE, index + 1, postE - 1);
        return node;
    }
}
