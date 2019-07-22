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

        public int find(int a) {
            if (a == roots[a]) return a;
            return find(roots[a]);
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
    }

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        UF uf = new UF(4 * N * N);
        // It is a math problem...
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                int root = 4 * (r * N + c);
                char val = grid[r].charAt(c);
                if (val != '\\') {
                    uf.union(root + 0, root + 1);
                    uf.union(root + 2, root + 3);
                }
                if (val != '/') {
                    uf.union(root + 0, root + 2);
                    uf.union(root + 1, root + 3);
                }

                // north south
                if (r + 1 < N)
                    uf.union(root + 3, (root + 4 * N) + 0);
                if (r - 1 >= 0)
                    uf.union(root + 0, (root - 4 * N) + 3);
                // east west
                if (c + 1 < N)
                    uf.union(root + 2, (root + 4) + 1);
                if (c - 1 >= 0)
                    uf.union(root + 1, (root - 4) + 2);
            }
        }
        int ans = 0;
        for (int x = 0; x < 4 * N * N; x++) {
            if (uf.find(x) == x)
                ans++;
        }
        return ans;
    }
}
