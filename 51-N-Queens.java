class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }

        search(results, new ArrayList<Integer>(), n);

        return results;
    }

    private void search(List<List<String>> results,
                        List<Integer> cols,
                        int n) {
        if (cols.size() == n) {
            results.add(drawChessboard(cols));
            return;
        }
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            search(results, cols, n);
            cols.remove(cols.size() - 1);
        }
    }

    private boolean isValid(List<Integer> cols, int colIndex) {
        int row = cols.size();
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            if (cols.get(rowIndex) == colIndex) {
                return false;
            }
            if (cols.get(rowIndex) + rowIndex == colIndex + cols.size()) {
                return false;
            }
            if (cols.get(rowIndex) - rowIndex == colIndex - cols.size()) {
                return false;
            }
        }
        return true;
    }

    private List<String> drawChessboard(List<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }
}
