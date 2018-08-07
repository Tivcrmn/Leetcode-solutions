class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) return nums[mid];
            else if (nums[mid] != nums[mid + 1]) {
                if ((end - mid) % 2 == 0) end = mid;
                else start = mid + 1;
            }
            else if (nums[mid] != nums[mid - 1]) {
                if ((mid - start) % 2 == 0) start = mid;
                else end = mid - 1;
            }
        }
        if (isOnce(start, nums)) return nums[start];
        if (isOnce(end, nums)) return nums[end];
        return nums[0];
    }

    private boolean isOnce(int i, int[] nums) {
        return (i + 1 >= nums.length || nums[i] != nums[i + 1])
               && (i - 1 < 0 || nums[i] != nums[i - 1]);
    }
}
