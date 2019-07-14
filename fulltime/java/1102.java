class Solution {
    class Position {
        int x;
        int y;
        int value;
        public Position(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    public int maximumMinimumPath(int[][] A) {
        PriorityQueue<Position> pq = new PriorityQueue<>((Position p1, Position p2) -> p2.value - p1.value);
        int m = A.length, n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dirs = {0, 1, 0, -1, 0};
        pq.offer(new Position(0, 0, A[0][0]));
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            Position p = pq.poll();
            if (p.x == m - 1 && p.y == n - 1) return p.value;
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dirs[i];
                int ny = p.y + dirs[i + 1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[nx][ny]) continue;
                pq.offer(new Position(nx, ny, Math.min(p.value, A[nx][ny])));
                visited[nx][ny] = true;
            }
        }
        // unreachable
        return -1;
    }
}
