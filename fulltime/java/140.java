class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>(wordDict);
        return helper(map, set, s);
    }

    private List<String> helper(Map<String, List<String>> map,
                                Set<String> set,
                                String s) {
        if (map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (int i = 0; i < s.length(); i++) {
            String w = s.substring(0, i + 1);
            if (set.contains(w)) {
                List<String> right = helper(map, set, s.substring(i + 1));
                for (String r : right) {
                    res.add((w + " " + r).trim());
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
