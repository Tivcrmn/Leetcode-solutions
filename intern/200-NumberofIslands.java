class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int res = 0;
        int width = grid.length;
        int length = grid[0].length;
        boolean[][] visited = new boolean[width][length];
        Queue<int[]> queue = new LinkedList<>();
        int[] di = new int[]{0, 1, 1, 0, -1, 0, 0, -1};
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == '0' || visited[i][j]) {
                    continue;
                } else {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] head = queue.poll();
                        int x = head[0];
                        int y = head[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = x + di[2 * k];
                            int ny = y + di[2 * k + 1];
                            if (isValid(nx, ny, width, length) && grid[nx][ny] == '1' && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isValid(int x, int y, int width, int length) {
        return x >= 0 && x < width && y >= 0 && y < length;
    }
}
