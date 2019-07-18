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
    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, (int[] l1, int[] l2) -> l1[0] - l2[0]);
        UF uf = new UF(N);
        for (int[] log : logs) {
            int a = log[1];
            int b = log[2];
            if (uf.union(a, b)) N--;
            if (N == 1) return log[0];
        }
        return -1;
    }
}
