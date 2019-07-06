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
    public int countNodes(TreeNode root) {
        // The time complexity is O(logn * logn) not O(logn)
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            return countNodes(root.left) + (1 << rightHeight);
        }
    }

    private int getHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            node = node.left;
            height++;
        }
        return height;
    }
}
