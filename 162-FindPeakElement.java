class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        int start = 0, end = nums.length - 1;
        int index = 0;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                index = mid;
                break;
            } else if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                end = mid;
            } else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (start > 0) {
            if (nums[start] > nums[start - 1] && nums[start] > nums[start + 1]) {
                index = start;
            }
        } else {
            if (nums[start] > nums[start + 1]) {
                index = start;
            }
        }

        if (end < nums.length - 1) {
            if (nums[end] > nums[end - 1] && nums[end] > nums[end + 1]) {
                index = end;
            }
        } else {
            if (nums[end] > nums[end - 1]) {
                index = end;
            }
        }
        return index;


    }
}
