class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[]{};

        int i = 0, j = 0, count = 0, m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        if (matrix.length == 1) return matrix[0];
        if (matrix[0].length == 1) {
            for (int d = 0; d < m; d++) {
                res[d] = matrix[d][0];
            }
            return res;
        }
        int[] dx = {-1, 1};
        int[] dy = {1, -1};
        int di = -1;

        while (count < res.length) {
            res[count] = matrix[i][j];
            count++;
            if (di == -1) {
                if (i == 0 && j != n - 1) {
                    j++;
                    di = 1;
                }
                else if (j == n - 1 && i != m - 1) {
                    i++;
                    di = 1;
                }
                else if (i == m - 1 && j != n - 1) {
                    j++;
                    di = 0;
                }
                else if (j == 0 && i != 0) {
                    i++;
                    di = 0;
                }
            } else {
                i += dx[di];
                j += dy[di];
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) di = -1;
            }
        }
        return res;
    }
}
