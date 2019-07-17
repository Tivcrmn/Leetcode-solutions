class Solution {
    int[] dirs = {0, 1, -1};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        update(board, x, y);
        return board;
    }

    private void update(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return;
        char cur = board[x][y];
        if (cur == 'M') {
            board[x][y] = 'X';
        } else if (cur == 'E') {
            int adjacents = count(board, x, y);
            if (adjacents == 0) {
                board[x][y] = 'B';
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        update(board, dirs[i] + x, dirs[j] + y);
                    }
                }
            } else {
                board[x][y] = ("" + adjacents).charAt(0);
            }
        }
    }

    private int count(char[][] board, int x, int y) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nx = dirs[i] + x;
                int ny = dirs[j] + y;
                if (nx >= 0 &&
                    ny >= 0 &&
                    nx < board.length &&
                    ny < board[0].length &&
                    board[nx][ny] == 'M') count++;
            }
        }
        return count;
    }
}
