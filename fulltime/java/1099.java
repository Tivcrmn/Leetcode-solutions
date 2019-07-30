class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        int sum = -1;
        while (l < r) {
            int s = A[l] + A[r];
            if (s < K) {
                l++;
                sum = Math.max(sum, s);
            } else if (s == K) r--;
            else r--;
        }
        return sum;
    }
}
