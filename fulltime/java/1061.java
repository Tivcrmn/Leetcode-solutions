class Solution {
    class UF {
        int[] roots;
        int[] ranks;
        int[] small;
        public UF() {
            roots = new int[26];
            ranks = new int[26];
            small = new int[26];
            Arrays.fill(ranks, 1);
            for (int i = 0; i < 26; i++) {
                roots[i] = i;
                small[i] = i;
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
                small[root_a] = Math.min(small[root_a], small[root_b]);
            } else {
                roots[root_a] = root_b;
                ranks[root_b] += ranks[root_a];
                small[root_b] = Math.min(small[root_a], small[root_b]);
            }
            return true;
        }
    }
    public String smallestEquivalentString(String A, String B, String S) {
        int len = A.length();
        UF uf = new UF();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int a = A.charAt(i) - 'a';
            int b = B.charAt(i) - 'a';
            uf.union(a, b);
        }
        for (char c : S.toCharArray()) {
            int index = c - 'a';
            int root = uf.find(index);
            sb.append("" + (char)(uf.small[root] + 97));
        }
        return sb.toString();
    }
}
