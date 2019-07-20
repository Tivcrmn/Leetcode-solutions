class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int[] dirs = {0, 1, 0, -1, 0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(i * n + j);
                }
            }
        }
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int x = pos / n, y = pos % n;
            for (int k = 0; k < 4; k++) {
                int nx = x + dirs[k];
                int ny = y + dirs[k + 1];
                if (nx >= 0 &&
                    ny >= 0 &&
                    nx < m &&
                    ny < n &&
                    rooms[nx][ny] > rooms[x][y] + 1) {
                    queue.offer(nx * n + ny);
                    rooms[nx][ny] = rooms[x][y] + 1;
                }
            }
        }
    }
}
