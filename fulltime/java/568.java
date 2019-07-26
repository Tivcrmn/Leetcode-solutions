class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;
        int K = days[0].length;

        int[][] dp = new int[K][N];
        boolean[][] reach = new boolean[K][N];

        for (int i = 0; i < N; i++) {
            if (i == 0 || flights[0][i] == 1) {
                dp[0][i] = days[i][0];
                reach[0][i] = true;
            }
        }

        for (int week = 1; week < K; week++) {
            for (int city = 0; city < N; city++) {
                for (int prevCity = 0; prevCity < N; prevCity++) {
                    if (reach[week - 1][prevCity] && (city == prevCity || flights[prevCity][city] == 1)) {
                        dp[week][city] = Math.max(dp[week][city], dp[week - 1][prevCity] + days[city][week]);
                        reach[week][city] = true;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, dp[K - 1][i]);
        }
        return max;
    }
}
