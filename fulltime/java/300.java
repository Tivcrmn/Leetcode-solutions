class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] tails = new int[nums.length];
        int size = 1;
        tails[0] = nums[0];
        for (int i = 1; i< nums.length; i++) {
            // find the first number which is larger than num
            int index = binarySearch(tails, nums[i], size - 1);
            if (index == -1) {
                index = size;
                size++;
            }
            tails[index] = nums[i];
        }
        return size;
    }

    private int binarySearch(int[] tails, int target, int size) {
        int lo = 0, hi = size;
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            int cur = tails[mid];
            if (cur < target) lo = mid + 1;
            else hi = mid;
        }
        if (tails[lo] >= target) return lo;
        if (tails[hi] >= target) return hi;
        return -1;
    }
}
