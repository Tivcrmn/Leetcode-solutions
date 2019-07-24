class Solution {
    public int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                int cur = i + coin;
                if (cur >= 0 && cur <= amount) {
                    dp[cur] = Math.min(dp[cur], dp[i] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : (int)dp[amount];
    }
}
