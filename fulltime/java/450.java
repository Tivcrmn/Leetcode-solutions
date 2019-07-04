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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val != key) {
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else {
                root.right = deleteNode(root.right, key);
            }
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode cur = root.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            root.val = cur.val;
            root.left = deleteNode(root.left, root.val);
        }
        return root;
    }
}
