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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // The note shows that the number of node is 1 - 100, otherwise it is possible to traverse all the nodes
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        traverse(root1, leaves1);
        traverse(root2, leaves2);
        if (leaves1.size() != leaves2.size()) return false;
        return leaves1.equals(leaves2);
    }

    private void traverse(TreeNode node, List<Integer> leave) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            leave.add(node.val);
        }
        traverse(node.left, leave);
        traverse(node.right, leave);
    }
}
