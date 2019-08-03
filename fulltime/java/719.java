class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0, hi = nums[n - 1] - nums[0];
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            int count = countPairs(mid, nums);
            if (count < k) lo = mid + 1;
            else hi = mid;
        }
        return countPairs(lo, nums) >= k ? lo : hi;
    }

    private int countPairs(int mid, int[] nums) {
        int j = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] - nums[i] <= mid) j++;
            count += j - i - 1;
        }
        return count;
    }
}
