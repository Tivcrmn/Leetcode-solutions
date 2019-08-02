class Solution {
    public int threeSumMulti(int[] A, int target) {
        long[] counts = new long[101];
        long ans = 0;
        for (int i = 0; i < A.length; i++) {
            counts[A[i]]++;
        }
        for (int i = 0; i <= target / 3; i++) {
            for (int j = i; j <= target / 2; j++) {
                int k = target - i - j;
                if (k < 0 || k >= 101 || k < j) continue;
                if (counts[i] == 0 || counts[j] == 0 || counts[k] == 0) continue;
                if (i == j && j == k) {
                    ans += (counts[i] - 2) * (counts[i] - 1) * counts[i] / 6;
                } else if (i == j && j != k) {
                    ans += (counts[i] - 1) * counts[i] / 2 * counts[k];
                } else if (i != j && j == k) {
                    ans += (counts[j] - 1) * counts[j] / 2 * counts[i];
                } else {
                    ans += counts[i] * counts[j] * counts[k];
                }
            }
        }
        return (int)(ans % 1000000007L);
    }
}
