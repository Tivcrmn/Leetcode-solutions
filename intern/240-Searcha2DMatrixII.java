class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int c = matrix[0].length;
        int r = 0;
        while (c > 0) {
            int[] pos = findTheFirstGENumber(matrix, r, c, target);
            if (pos[0] == -1) return false;
            else if (matrix[pos[0]][pos[1]] == target) return true;
            else {
                r = pos[0] + 1;
                c = pos[1];
            }
        }
        return false;
    }

    private int[] findTheFirstGENumber(int[][] matrix, int row, int col, int target) {
        for (int i = row; i < matrix.length; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] >= target) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
}
