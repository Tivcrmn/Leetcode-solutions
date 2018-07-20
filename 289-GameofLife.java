class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] count = new int[m][n];
        int[] dx = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        int[] dy = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 8; k++) {
                    if (valid(m, n, i + dx[k], j + dy[k])) count[i + dx[k]][j + dy[k]] += board[i][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0 && count[i][j] == 3) board[i][j] = 1;
                else if (board[i][j] == 1 && (count[i][j] < 2 || count[i][j] > 3)) board[i][j] = 0;
            }
        }
    }

    private boolean valid(int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
