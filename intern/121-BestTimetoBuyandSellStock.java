class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[prices.length];
        dp[0] = Integer.MAX_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i - 1]);
            res = Math.max(res, prices[i] - dp[i]);
        }
        return res;

    }
}
