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
    int sum;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        StringBuilder sb = new StringBuilder();
        sb.append("" + root.val);
        helper(root, sb);
        return sum;
    }

    private void helper(TreeNode node, StringBuilder cur) {
        if (node.left == null && node.right == null) {
            sum += Integer.parseInt(cur.toString());
            return;
        }
        if (node.left != null) {
            cur.append("" + node.left.val);
            helper(node.left, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (node.right != null) {
            cur.append("" + node.right.val);
            helper(node.right, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
