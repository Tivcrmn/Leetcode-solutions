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
    TreeNode n1, n2, pre;
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if (pre != null && pre.val > root.val) {
                if (n1 == null) {
                    n1 = pre;
                    n2 = root;
                } else {
                    n2 = root;
                }
            }
            pre = root;
            root = root.right;
        }
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}
