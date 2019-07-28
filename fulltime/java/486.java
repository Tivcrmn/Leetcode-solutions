class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length % 2 == 0) return true;
        int[][] memo = new int[nums.length][nums.length];
        for (int[] m : memo) {
            Arrays.fill(m, Integer.MIN_VALUE);
        }
        return helper(nums, memo, 0, nums.length - 1) >= 0;
    }

    private int helper(int[] nums, int[][] memo, int i, int j) {
        if (i == j) return nums[i];
        if (memo[i][j] > Integer.MIN_VALUE) return memo[i][j];
        memo[i][j] = Math.max(nums[i] - helper(nums, memo, i + 1, j), nums[j] - helper(nums, memo, i, j - 1));
        return memo[i][j];
    }
}
