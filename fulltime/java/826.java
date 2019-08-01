class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[]{difficulty[i], profit[i]};
        }
        Arrays.sort(pairs, (p1, p2) -> p1[0] - p2[0]);
        TreeMap<Integer, Integer> ts = new TreeMap<>();
        int max = 0, count = 0;
        for (int i = 1; i < n; i++) {
            pairs[i][1] = Math.max(pairs[i][1], pairs[i - 1][1]);
        }
        for (int i = 0; i < n; i++) {
            ts.put(pairs[i][0], pairs[i][1]);
        }
        for (int w : worker) {
            Integer key = ts.floorKey(w);
            if (key != null) {
                count += ts.get(key);
            }
        }
        return count;
    }
}
