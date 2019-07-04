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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                st.push(root.left);
                root = root.right;
            }
            root = st.pop();
        }
        Collections.reverse(res);
        return res;
    }
}
