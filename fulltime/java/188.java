class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        k = Math.min(prices.length / 2, k);
        int res = 0;
        int[][] pre_dp = new int[2][k + 1];
        int[][] cur_dp = new int[2][k + 1];
        for (int i = 0; i <= k; i++) {
            pre_dp[1][i] = -prices[0];
        }
        for (int m = 1; m < prices.length; m++) {
            cur_dp[0][0] = pre_dp[0][0];
            cur_dp[1][0] = Math.max(pre_dp[1][0], pre_dp[0][0] - prices[m]);
            for (int n = 1; n <= k; n++) {
                cur_dp[0][n] = Math.max(pre_dp[0][n], pre_dp[1][n - 1] + prices[m]);
                cur_dp[1][n] = Math.max(pre_dp[1][n], pre_dp[0][n] - prices[m]);
            }
            res = Math.max(res, cur_dp[0][k]);
            pre_dp = cur_dp;
        }

        return res;
    }
}
