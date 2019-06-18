class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > max) max = nums[j];
                if (max > nums[i] && max > nums[j] && nums[i] < nums[j]) return true;
            }
        }
        return false;
    }
}
