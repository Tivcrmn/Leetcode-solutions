class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            int numOfSmaller = getNumOfSmaller(mid, m, n);
            if (numOfSmaller >= k) hi = mid;
            else lo = mid;
        }
        // getNumOfSmaller(lo, m, n) >= k also pass
        return getNumOfSmaller(lo, m, n) == k ? lo : hi;
    }

    private int getNumOfSmaller(int num, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(num / i, n);
        }
        return count;
    }
}
