class Solution {
    public String minWindow(String S, String T) {
        int m = S.length(), n = T.length();
        if (m < n) return "";
        int minLen = S.length() + 1, start = -1;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (S.charAt(i) == T.charAt(0)) dp[i][0] = i;
            else if (i > 0) dp[i][0] = dp[i - 1][0];
            else dp[i][0] = -1;
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = -1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (i < j) dp[i][j] = -1;
                else if (S.charAt(i) == T.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (dp[i][n - 1] != -1) {
                int len = i - dp[i][n - 1] + 1;
                if (len < minLen) {
                    minLen = len;
                    start = dp[i][n - 1];
                }
            }
        }

        return start == -1 ? "" : S.substring(start, start + minLen);
    }
}
