class Solution {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        Set<String> paths = new HashSet<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, -1);
                    paths.add(sb.toString());
                }
            }
        }
        return paths.size();
    }

    private void dfs(int[][] grid, int x, int y, StringBuilder sb, int direction) {
        int[] dirs = {0, 1, 0, -1, 0};
        sb.append(direction);
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[i];
            int ny = y + dirs[i + 1];
            if (nx >= 0 &&
                ny >= 0 &&
                nx < grid.length &&
                ny < grid[0].length &&
                grid[nx][ny] == 1) {
                dfs(grid, nx, ny, sb, i);
            }
        }
        sb.append(" ");
    }
}
