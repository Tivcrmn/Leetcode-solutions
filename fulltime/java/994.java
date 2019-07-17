class Solution {
    int m, n;
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> queue = new LinkedList<>();
        int[] dirs = {0, 1, 0, -1, 0};
        int minute = 0;
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(i * n + j);
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            minute++;
            for (int k = 0; k < size; k++) {
                int pos = queue.poll();
                int x = pos / n, y = pos % n;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dirs[i];
                    int ny = y + dirs[i + 1];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny] && grid[nx][ny] == 1) {
                        queue.offer(nx * n + ny);
                        visited[nx][ny] = true;
                        fresh--;
                    }
                }
            }
        }
        if (fresh != 0) return -1;
        return minute == 0 ? 0 : minute - 1;
    }
}
