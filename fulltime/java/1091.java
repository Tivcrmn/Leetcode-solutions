class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int[] dirs = {0, 1, -1};
        boolean[][] visited = new boolean[N][N];
        if (grid[0][0] == 0) {
            queue.offer(0);
            visited[0][0] = true;
        }
        if (grid[N - 1][N - 1] == 1) return -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int k = 0; k < size; k++) {
                int pos = queue.poll();
                int x = pos / N, y = pos % N;
                if (x == N - 1 && y == N - 1) return count;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int nx = x + dirs[i];
                        int ny = y + dirs[j];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && grid[nx][ny] == 0) {
                            queue.offer(nx * N + ny);
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
