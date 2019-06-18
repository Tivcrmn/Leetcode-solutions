class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        if (nums.length > 0) {
            dp[0] = nums[0];
        }
        if (nums.length > 1) {
            dp[1] = Math.max(nums[1], nums[0]);
        }
        for (int i = 2; i < nums.length; i++) {
            if (i == 2) {
                dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            } else {
                dp[i] = Math.max(Math.max(dp[i - 2], dp[i - 3]) + nums[i], dp[i - 1]);
            }
        }
        return dp[nums.length - 1];
    }
}
