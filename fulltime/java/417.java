class Solution {
    int m, n;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // I add the cache.. but it is even slower than the no-cache version
        List<List<Integer>> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        m = matrix.length;
        n = matrix[0].length;
        // 0 is not visited, 1 is reachable, 2 is not reachable
        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean reachPacific = dfs(matrix, pacific, i, j, true, new boolean[m][n]);
                boolean reachAtlantic = dfs(matrix, atlantic, i, j, false, new boolean[m][n]);
                if (!reachPacific) {
                    pacific[i][j] = 2;
                }
                if (!reachAtlantic) {
                    atlantic[i][j] = 2;
                }
                if (reachPacific && reachAtlantic) {
                    List<Integer> pos = new ArrayList<>();
                    pos.add(i);
                    pos.add(j);
                    res.add(pos);
                }
            }
        }
        return res;
    }

    private boolean dfs(int[][] matrix,
                        int[][] reach,
                        int x,
                        int y,
                        boolean pacific,
                        boolean[][] visited) {
        if (reach[x][y] == 1) return true;
        if (reach[x][y] == 2) return false;
        visited[x][y] = true;
        int[] dirs = {0, 1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int nx = x + dirs[i];
            int ny = y + dirs[i + 1];
            if (nx < 0 || ny < 0) {
                if (!pacific) continue;
                reach[x][y] = 1;
                return true;
            }
            if (nx >= m || ny >= n) {
                if (pacific) continue;
                reach[x][y] = 1;
                return true;
            }
            if (matrix[nx][ny] <= matrix[x][y] && !visited[nx][ny]) {
                if (dfs(matrix, reach, nx, ny, pacific, visited)) {
                    reach[x][y] = 1;
                    return true;
                }
            }
        }
        return false;
    }
}
