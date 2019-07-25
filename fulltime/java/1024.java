class Solution {
    public int videoStitching(int[][] slices, int T) {
        int[] dp = new int[T + 1];
	    Arrays.fill(dp, slices.length + 1);
	    dp[0] = 0;
        for (int i = 1; i <= T; i++) {
	        for (int[] slice : slices) {
		        if (slice[1] < i || slice[0] > i) continue;
                dp[i] = Math.min(dp[i], dp[slice[0]] + 1);
            }
        }
        return dp[T] == slices.length + 1 ? -1 : dp[T];
    }
}
