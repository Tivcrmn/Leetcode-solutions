class Solution {
    public String minWindow(String S, String T) {
        int m = S.length(), n = T.length(), min = S.length() + 1, start = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i + 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i <= m; i++) {
            if (i - dp[i][n] + 1 < min) {
                min = i - dp[i][n] + 1;
                start = dp[i][n] - 1;
            }
        }
        return min == S.length() + 1 ? "" : S.substring(start, start + min);
    }
}
