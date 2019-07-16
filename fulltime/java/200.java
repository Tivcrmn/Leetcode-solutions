// dfs
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    num++;
                }
            }
        }
        return num;
    }

    private void dfs(int i, int j, char[][] grid) {
        grid[i][j] = '0';
        int[] dirs = {0, 1, 0, -1, 0};
        for (int k = 0; k < 4; k++) {
            int nx = i + dirs[k];
            int ny = j + dirs[k + 1];
            if (valid(nx, ny, grid)) {
                dfs(nx, ny, grid);
            }
        }
    }

    private boolean valid(int x, int y, char[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1';
    }
}

// bfs(TLE)
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(int i, int j, char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0], y = pos[1];
            grid[x][y] = '0';
            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                queue.offer(new int[]{x - 1, y});
            }
            if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                queue.offer(new int[]{x + 1, y});
            }
            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                queue.offer(new int[]{x, y - 1});
            }
            if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
                queue.offer(new int[]{x, y + 1});
            }
        }
    }
}

// union find
class Solution {
    class UF {
        int[] roots;
        int[] ranks;
        public UF(int size) {
            roots = new int[size];
            ranks = new int[size];
            Arrays.fill(ranks, 1);
            for (int i = 0; i < size; i++) {
                roots[i] = i;
            }
        }

        public boolean union(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            if (root_a == root_b) return false;
            if (ranks[root_a] > ranks[root_b]) {
                roots[root_b] = root_a;
                ranks[root_a] += ranks[root_b];
            } else {
                roots[root_a] = root_b;
                ranks[root_b] += ranks[root_a];
            }
            return true;
        }

        public int find(int a) {
            if (a == roots[a]) return a;
            return find(roots[a]);
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length, count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') count++;
            }
        }
        UF uf = new UF(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                int p = i * n + j;
                if (i > 0 && grid[i - 1][j] == '1' && uf.union(p, (i - 1) * n + j)) {
                    count--;
                }
                if (i < m - 1 && grid[i + 1][j] == '1' && uf.union(p, (i + 1) * n + j)) {
                    count--;
                }
                if (j > 0 && grid[i][j - 1] == '1' && uf.union(p, i * n + j - 1)) {
                    count--;
                }
                if (j < n - 1 && grid[i][j + 1] == '1' && uf.union(p, i * n + j + 1)) {
                    count--;
                }
            }
        }
        return count;
    }
}
