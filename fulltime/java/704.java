class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] == target) {
            return l;
        }
        if (nums[r] == target) {
            return r;
        }
        return -1;
    }
}
