class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // I do not like any greedy problem. Any!
        int cur = startFuel;
        int stops = 0;
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (true) {
            if (cur >= target) return stops;
            while (i < stations.length && stations[i][0] <= cur) {
                pq.add(stations[i++][1]);
            }
            if (pq.isEmpty()) return -1;
            cur += pq.poll();
            stops++;
        }
    }
}
