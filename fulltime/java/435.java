class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];
            if (interval[0] >= end) {
                end = interval[1];
                count++;
            }
        }
        return n - count;
    }
}
