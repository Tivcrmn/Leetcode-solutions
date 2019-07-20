class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (flights.length == 0) return -1;
        List<List<Integer>> next = new ArrayList<>();
        Map<String, Integer> prices = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0, 0});
        for (int i = 0; i < n; i++) {
            next.add(new ArrayList<>());
        }
        for (int[] f : flights) {
            int s = f[0], d = f[1], p = f[2];
            next.get(s).add(d);
            prices.put(s + " " + d, p);
        }
        while (!pq.isEmpty()) {
            int[] tuple = pq.poll();
            int cur = tuple[0], localPrice = tuple[1], stops = tuple[2];
            if (cur == dst) return localPrice;
            if (stops <= K) {
                for (int nex : next.get(cur)) {
                    int p = prices.get(cur + " " + nex);
                    pq.offer(new int[]{nex, localPrice + p, stops + 1});
                }
            }
        }
        return -1;
    }
}
