class Solution {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && isValid(i - 1, j, board) && isValid(i, j - 1, board)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isValid(int i, int j, char[][] board) {
        if (i < 0 || i > board.length || j < 0 || j > board[0].length || board[i][j] == '.') {
            return true;
        }
        return false;
    }
}
