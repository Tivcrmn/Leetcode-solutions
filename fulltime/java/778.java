class Solution {
    class Position {
        int x;
        int y;
        int time;
        public Position(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public int swimInWater(int[][] grid) {
        PriorityQueue<Position> pq = new PriorityQueue<>((Position p1, Position p2) -> p1.time - p2.time);
        int[] dirs = {0, 1, 0, -1, 0};
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        pq.offer(new Position(0, 0, grid[0][0]));
        while (!pq.isEmpty()) {
            Position p = pq.poll();
            if (p.x == m - 1 && p.y == n - 1) return p.time;
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dirs[i];
                int ny = p.y + dirs[i + 1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                pq.offer(new Position(nx, ny, Math.max(p.time, grid[nx][ny])));
            }
        }
        // unreachable
        return -1;
    }
}
