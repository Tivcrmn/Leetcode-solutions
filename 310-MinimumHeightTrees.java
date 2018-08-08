class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        if (n <= 0 || edges.length + 1 != n) return res;
        if (n == 1) {
            res.add(0);
            return res;
        }
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(i).size() == 1) leaves.add(i);
        }
        while (n > 2) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int leave : leaves) {
                Set<Integer> nbs = map.get(leave);
                for (int nb : nbs) {
                    map.get(nb).remove(leave);
                    if (map.get(nb).size() == 1) newLeaves.add(nb);
                }
                n--;
            }
            leaves = newLeaves;
        }
        return new ArrayList<>(leaves);
    }
}
