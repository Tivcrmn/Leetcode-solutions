class Solution {
    class Pair {
        int c;
        int p;
        public Pair(int c, int p) {
            this.c = c;
            this.p = p;
        }
    }
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int n = Profits.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(Capital[i], Profits[i]));
        }
        Collections.sort(pairs, (p1, p2) -> p1.c - p2.c);
        int index = 0;
        while (k > 0) {
            while (index < n && pairs.get(index).c <= W) {
                pq.offer(pairs.get(index).p);
                index++;
            }
            if (pq.isEmpty()) break;
            W += pq.poll();
            k--;
        }
        return W;
    }
}
