class Solution {
    public int countArrangement(int N) {
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        helper(1, visited, res);
        return res.size();
    }

    private void helper(int count, boolean[] visited, List<Integer> res) {
        if (count == visited.length) {
            res.add(1);
            return;
        }
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i] && (count % i == 0 || i % count == 0)) {
                visited[i] = true;
                helper(count + 1, visited, res);
                visited[i] = false;
            }
        }
    }
}
