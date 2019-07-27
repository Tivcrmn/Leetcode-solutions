class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) return false;
        int sub = sum / k;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > sub) return false;
        int p = nums.length - 1;
        while (p >= 0) {
            if (nums[p] == sub) {
                k--;
                p--;
            } else {
                break;
            }
        }
        return helper(new int[k], nums, p, sub);
    }

    private boolean helper(int[] subsets, int[] nums, int end, int sub) {
        if (end < 0) return true;
        int selected = nums[end];
        for (int i = 0; i < subsets.length; i++) {
            if (subsets[i] + selected <= sub) {
                subsets[i] += selected;
                if (helper(subsets, nums, end - 1, sub)) return true;
                subsets[i] -= selected;
            }
        }
        return false;
    }
}
