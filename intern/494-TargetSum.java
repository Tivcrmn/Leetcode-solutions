class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        List<Integer> res = new ArrayList<>();
        helper(nums, 0, S, res);
        return res.size();
    }

    private void helper(int[] nums, int curIndex, int remain, List<Integer> res) {
        if (curIndex == nums.length - 1) {
            if (remain + nums[curIndex] == 0) {
                res.add(1);
            }
            if (remain - nums[curIndex] == 0) {
                res.add(1);
            }
        } else {
            helper(nums, curIndex + 1, remain - nums[curIndex], res);
            helper(nums, curIndex + 1, remain + nums[curIndex], res);
        }
    }
}
