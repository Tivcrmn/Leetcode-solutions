class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (!isValid(i - 1, j, m, n) || grid[i - 1][j] == 0) res++;
                    if (!isValid(i, j - 1, m, n) || grid[i][j - 1] == 0) res++;
                    if (!isValid(i + 1, j, m, n) || grid[i + 1][j] == 0) res++;
                    if (!isValid(i, j + 1, m, n) || grid[i][j + 1] == 0) res++;
                }
            }
        }
        return res;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
