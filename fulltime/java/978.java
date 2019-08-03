class Solution {
    public int maxTurbulenceSize(int[] A) {
        int n = A.length, max = 1;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = 1;
        dp2[0] = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] == A[i - 1]) {
                dp1[i] = 1;
                dp2[i] = 1;
            } else if (A[i] < A[i - 1]) {
                if (i % 2 == 0) {
                    dp1[i] = Math.max(dp1[i - 1] + 1, dp1[i]);
                    dp2[i] = 1;
                } else {
                    dp2[i] = Math.max(dp2[i - 1] + 1, dp2[i]);
                    dp1[i] = 1;
                }
            } else {
                if (i % 2 == 1) {
                    dp1[i] = Math.max(dp1[i - 1] + 1, dp1[i]);
                    dp2[i] = 1;
                } else {
                    dp2[i] = Math.max(dp2[i - 1] + 1, dp2[i]);
                    dp1[i] = 1;
                }
            }
            max = Math.max(max, Math.max(dp1[i], dp2[i]));
        }
        return max;
    }
}
