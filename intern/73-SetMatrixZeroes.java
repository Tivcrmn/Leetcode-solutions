class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] state = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 && !state[i][j]) {
                    for (int k = 0; k < m; k++) {
                        if (matrix[k][j] != 0) {
                            state[k][j] = true;
                            matrix[k][j] = 0;
                        }
                    }
                    for (int k = 0; k < n; k++) {
                        if (matrix[i][k] != 0) {
                            matrix[i][k] = 0;
                            state[i][k] = true;
                        }
                    }
                }
            }
        }
        return;
    }
}
