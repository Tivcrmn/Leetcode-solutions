class Solution {
    int m, n;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int cur) {
        if (cur >= word.length()) return true;
        if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] == '.' || board[x][y] != word.charAt(cur)) return false;
        char c = board[x][y];
        board[x][y] = '.';
        int[] dirs = {0, 1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[i];
            int ny = y + dirs[i + 1];
            if (dfs(board, nx, ny, word, cur + 1)) return true;
        }
        board[x][y] = c;
        return false;
    }
}
