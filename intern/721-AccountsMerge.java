class Solution {
    class UnionFind {
        int[] father;
        public UnionFind(int size) {
            father = new int[size];
            for (int i = 0; i < size; i++) {
                father[i] = i;
            }
        }

        public void union(int a, int b) {
            int root_a = find(a);
            int root_b = find(b);
            if (root_a != root_b) {
                father[root_a] = root_b;
            }
        }

        public int find(int a) {
            if (father[a] == a) return a;
            return father[a] = find(father[a]);
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        UnionFind uf = new UnionFind(accounts.size());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> emails = accounts.get(i);
            for (int j = 1; j < emails.size(); j++) {
                String email = emails.get(j);
                if (!map.containsKey(email)) {
                    map.put(email, i);
                }
                uf.union(map.get(email), i);
            }
        }
        HashMap<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : map.keySet()) {
            int root = uf.find(map.get(email));
            if (!indexToEmails.containsKey(root)) indexToEmails.put(root, new ArrayList<String>());
            indexToEmails.get(root).add(email);
        }
        for (Integer i : indexToEmails.keySet()) {
            List<String> ans = new ArrayList<>();
            ans.add(accounts.get(i).get(0));
            List<String> emails = indexToEmails.get(i);
            Collections.sort(emails);
            ans.addAll(emails);
            res.add(ans);
        }
        return res;
    }
}
