class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, 0, new ArrayList<Integer>(), n);
        return res;
    }

    private void dfs(List<List<String>> res, int cur, List<Integer> columns, int n) {
        if (cur == n) {
            res.add(print(columns));
            return;
        }
        for (int col = 0; col < n; col++) {
            boolean can = true;
            for (int i = 0; i < columns.size(); i++) {
                int r = i, c = columns.get(i);
                int nr = cur, nc = col;
                if (c == nc || c + r == nr + nc || c - r == nc - nr) {
                    can = false;
                    break;
                }
            }
            if (can) {
                columns.add(col);
                dfs(res, cur + 1, columns, n);
                columns.remove(columns.size() - 1);
            }
        }
    }

    private List<String> print(List<Integer> columns) {
        List<String> res = new ArrayList<>();
        int n = columns.size();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int index = columns.get(i);
            for (int j = 0; j < n; j++) {
                if (j == index) sb.append("Q");
                else sb.append(".");
            }
            res.add(sb.toString());
        }
        return res;
    }
}
