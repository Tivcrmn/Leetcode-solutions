class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = 0;
        while (m >= 2 && n >= 2) {
            // [i, j] -> [i, j + n - 2]
            for (int p = j; p < j + n - 1; p++) {
                res.add(matrix[i][p]);
            }
            // [i, j + n - 1] -> [i + m - 2, j + n - 1]
            for (int p = i; p < i + m - 1; p++) {
                res.add(matrix[p][j + n - 1]);
            }
            // [i + m - 1, j + n - 1] -> [i + m - 1, j + 1]
            for (int p = j + n - 1; p > j; p--) {
                res.add(matrix[i + m - 1][p]);
            }
            // [i + m - 1, j] -> [i + 1, j]
            for (int p = i + m - 1; p > i; p--) {
                res.add(matrix[p][j]);
            }
            m -= 2;
            n -= 2;
            i += 1;
            j += 1;
            // [[3],[2]]
        }

        if (m == 1) {
            for (int k = j; k < j + n; k++) {
                res.add(matrix[i][k]);
            }
        } else if (n == 1) {
            for (int k = i; k < i + m; k++) {
                res.add(matrix[k][j]);
            }
        }
        return res;
    }
}
