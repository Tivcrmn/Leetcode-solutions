class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            int newTarget = target - nums[i];
            while (left < right) {
                if (nums[left] + nums[right] == newTarget) {
                    diff = 0;
                    break;
                } else if (nums[left] + nums[right] > newTarget) {
                    diff = Math.abs(diff) > Math.abs(newTarget - nums[left] - nums[right]) ?
                        newTarget - nums[left] - nums[right] : diff;
                    right--;
                } else {
                    diff = Math.abs(diff) > Math.abs(newTarget - nums[left] - nums[right]) ?
                        newTarget - nums[left] - nums[right] : diff;
                    left++;
                }
            }
        }
        return target - diff;
    }
}
