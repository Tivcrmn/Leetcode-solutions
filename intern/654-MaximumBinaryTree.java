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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        TreeNode root = null;
        if (start == end) {
            root = new TreeNode(nums[start]);
        } else if (start < end) {
            int max = 0;
            int maxIndex = 0;
            for (int i = start; i <= end; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            root = new TreeNode(max);
            root.left = helper(nums, start, maxIndex - 1);
            root.right = helper(nums, maxIndex + 1, end);
        }
        return root;
    }
}
