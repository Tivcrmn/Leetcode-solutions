class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1; dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            if (isValid(s.charAt(i - 1), s.charAt(i))) dp[i + 1] += dp[i - 1];
            if (s.charAt(i) >= '1' && s.charAt(i) <= '9') dp[i + 1] += dp[i];
        }
        return dp[s.length()];
    }

    private boolean isValid(char a, char b) {
        return (a == '1' && b >= '0' && b <= '9') || (a == '2' && b >= '0' && b <= '6');
    }
}
