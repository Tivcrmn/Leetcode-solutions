// dfs
class Solution {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        boolean[] visited = new boolean[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i, visited, M);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, boolean[] visited, int[][] M) {
        visited[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                dfs(j, visited, M);
            }
        }
    }
}

// bfs
class Solution {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        boolean[] visited = new boolean[N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                bfs(i, visited, M);
                count++;
            }
        }
        return count;
    }

    private void bfs(int i, boolean[] visited, int[][] M) {
        Queue<Integer> queue = new LinkedList<>();
        visited[i] = true;
        queue.offer(i);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int j = 0; j < M.length; j++) {
                if (M[cur][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }
}

// union-find
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

    public int findCircleNum(int[][] M) {
        int N = M.length;
        UF uf = new UF(N);
        int size = N;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (M[i][j] == 1 && uf.union(i, j)) {
                    size--;
                }
            }
        }
        return size;
    }
}
