class Solution {
    class UF {
        int[] roots;
        int[] ranks;
        public UF() {
            roots = new int[26];
            ranks = new int[26];
            Arrays.fill(ranks, 1);
            for (int i = 0; i < 26; i++) {
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
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF();
        for (String equation : equations) {
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '=') uf.union(a, b);

        }
        for (String equation : equations) {
            int a = equation.charAt(0) - 'a';
            int b = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '!') {
                int root_a = uf.find(a);
                int root_b = uf.find(b);
                if (root_a == root_b) return false;
            }
        }
        return true;
    }
}
