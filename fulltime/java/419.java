class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int m = board.length, n = board[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // when we get last X in each battleship, we count 1
                if (board[i][j] == 'X' && isValid(i + 1, j, board) && isValid(i, j + 1, board)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isValid(int i, int j, char[][] board) {
        return i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '.';
    }
}
