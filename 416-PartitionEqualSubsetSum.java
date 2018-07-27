class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        Arrays.sort(nums);
        return helper(nums, sum / 2, 0);
    }

    private boolean helper(int[] nums, int target, int start) {
        if (target == 0) return true;
        for (int i = start; i < nums.length && nums[i] <= target; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            if (helper(nums, target - nums[i], i + 1)) return true;
        }
        return false;
    }
}
