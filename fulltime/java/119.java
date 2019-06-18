class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = res.size() - 1; j > 0; j--) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
            res.add(1);
        }
        return res;
    }
}
