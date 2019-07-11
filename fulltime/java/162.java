class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (mid != 0 && nums[mid] < nums[mid - 1]) hi = mid - 1;
            else if (mid != nums.length - 1 && nums[mid] < nums[mid + 1]) lo = mid + 1;
            else return mid;
        }
        return nums[lo] < nums[hi] ? hi : lo;
    }
}
