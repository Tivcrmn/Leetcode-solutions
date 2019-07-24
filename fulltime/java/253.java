class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = pq.peek();
            int[] interval = intervals[i];
            if (cur[1] <= interval[0]) {
                cur = pq.poll();
                cur[1] = interval[1];
                pq.offer(cur);
            } else {
                pq.offer(interval);
            }
        }
        return pq.size();
    }
}
