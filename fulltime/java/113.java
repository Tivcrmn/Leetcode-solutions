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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> ans = new ArrayList<>();
        ans.add(root.val);
        helper(res, ans, root, root.val, sum);
        return res;
    }

    private void helper(List<List<Integer>> res,
                        List<Integer> ans,
                        TreeNode node,
                        int cur,
                        int sum) {
        if (cur == sum && node.left == null && node.right == null) {
            res.add(new ArrayList<>(ans));
        }
        if (node.left != null) {
            ans.add(node.left.val);
            helper(res, ans, node.left, cur + node.left.val, sum);
            ans.remove(ans.size() - 1);
        }
        if (node.right != null) {
            ans.add(node.right.val);
            helper(res, ans, node.right, cur + node.right.val, sum);
            ans.remove(ans.size() - 1);
        }
    }
}
