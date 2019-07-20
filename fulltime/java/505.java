class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[][] distance = new int[m][n];
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        int[] dirs = {0, 1, 0, -1, 0};
        pq.offer(new int[]{start[0], start[1]});
        while (!pq.isEmpty()) {
            int[] pos = pq.poll();
            int x = pos[0], y = pos[1];
            for (int i = 0; i < 4; i++) {
                int nx = x, ny = y;
                int count = 0;
                while (nx >= 0 && ny >= 0 && nx < m && ny < n && maze[nx][ny] == 0) {
                    nx += dirs[i];
                    ny += dirs[i + 1];
                    count++;
                }
                if (distance[x][y] + count - 1 < distance[nx - dirs[i]][ny - dirs[i + 1]]) {
                    pq.offer(new int[]{nx - dirs[i], ny - dirs[i + 1]});
                    distance[nx - dirs[i]][ny - dirs[i + 1]] = distance[x][y] + count - 1;
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}
