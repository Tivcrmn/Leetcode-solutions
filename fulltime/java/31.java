class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int swapIndex1 = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                swapIndex1 = i - 1;
                break;
            }
        }
        if (swapIndex1 == -1) {
            Arrays.sort(nums);
            return;
        }
        int swapIndex2 = binarySearch(nums, swapIndex1 + 1, nums[swapIndex1]);
        swap(nums, swapIndex1, swapIndex2);
        Arrays.sort(nums, swapIndex1 + 1, nums.length);
    }

    private int binarySearch(int[] nums, int start, int target) {
        int lo = start, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            int cur = nums[mid];
            if (cur > target) lo = mid;
            else hi = mid;
        }
        return nums[hi] > target ? hi : lo;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
