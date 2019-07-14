class Solution {
    public int splitArray(int[] nums, int m) {
        long lo = 0, hi = 0;
        for (int num : nums) {
           lo = Math.max(num, lo);
            hi += num;
        }
        while (lo + 1 < hi) {
            long mid = (hi - lo) / 2 + lo;
            int groups = count(nums, mid);
            if (groups > m) lo = mid + 1;
            else hi = mid;
        }
        return count(nums, lo) <= m ? (int)lo : (int)hi;
    }

    private int count(int[] nums, long target) {
        long cur = 0;
        int group = 0;
        for (int num : nums) {
            if (cur + num > target) {
                group++;
                cur = num;
            } else if (cur + num == target) {
                group++;
                cur = 0;
            } else {
                cur += num;
            }
        }
        if (cur > 0) group++;
        return group;
    }
}
