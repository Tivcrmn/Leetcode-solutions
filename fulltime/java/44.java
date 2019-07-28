class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int pi = 1; pi <= p.length(); pi++) {
            if (p.charAt(pi - 1) == '*' && dp[0][pi - 1]) {
                dp[0][pi] = true;
            }
        }
        for (int si = 1; si <= s.length(); si++) {
            for (int pi = 1; pi <= p.length(); pi++) {
                if (p.charAt(pi - 1) == s.charAt(si - 1) || p.charAt(pi - 1) == '?') {
                    dp[si][pi] = dp[si - 1][pi - 1];
                } else if (p.charAt(pi - 1) == '*') {
                    dp[si][pi] = dp[si][pi - 1] || dp[si - 1][pi];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
