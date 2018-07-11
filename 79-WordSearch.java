class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (find(i, j, board, word, visited)) return true;
            }
        }
        return false;
    }

    private boolean find(int i, int j, char[][] board, String word, boolean[][] visited) {
        if (word.length() == 0) {
            return true;
        } else if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(0)) {
            return false;
        } else {
            visited[i][j] = true;
            if (find(i - 1, j, board, word.substring(1), visited)) return true;
            if (find(i, j - 1, board, word.substring(1), visited)) return true;
            if (find(i + 1, j, board, word.substring(1), visited)) return true;
            if (find(i, j + 1, board, word.substring(1), visited)) return true;
            visited[i][j] = false;
            return false;
        }
    }
}
