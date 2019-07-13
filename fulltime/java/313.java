class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int[] indexs = new int[primes.length];
        while (res.size() < n) {
            int next = Integer.MAX_VALUE;
            for (int i = 0; i < primes.length; i++) {
                next = Math.min(next, res.get(indexs[i]) * primes[i]);
            }
            for (int i = 0; i < primes.length; i++) {
                if (next == res.get(indexs[i]) * primes[i]) indexs[i]++;
            }
            res.add(next);
        }
        return res.get(n - 1);
    }
}
