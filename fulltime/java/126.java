class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // TLE.. fix later
        Set<String> wordSet = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        for (String word : wordList) {
            wordSet.add(word);
        }
        if (!wordSet.contains(endWord)) return res;
        // bfs to find the shortest length
        Queue<String> queue = new LinkedList<>();
        int len = 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        queue.offer(beginWord);
        boolean find = false;
        while (!queue.isEmpty() && !find) {
            int size = queue.size();
            len++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    find = true;
                    break;
                }
                for (String next : getNext(cur, wordSet)) {
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        if (!find) return res;
        // dfs with pruning
        List<String> ans = new ArrayList<>();
        visited = new HashSet<>();
        ans.add(beginWord);
        visited.add(beginWord);
        dfs(beginWord, endWord, visited, len, res, ans, wordSet);
        return res;
    }

    private void dfs(String s,
                     String e,
                     Set<String> visited,
                     int len,
                     List<List<String>> res,
                     List<String> ans,
                     Set<String> wordSet) {
        if (ans.size() >= len) return;
        for (String next : getNext(s, wordSet)) {
            if (!visited.contains(next)) {
                ans.add(next);
                visited.add(next);
                if (next.equals(e)) {
                    res.add(new ArrayList<String>(ans));
                } else {
                    dfs(next, e, visited, len, res, ans, wordSet);
                }
                visited.remove(next);
                ans.remove(ans.size() - 1);
            }
        }
    }

    private List<String> getNext(String s, Set<String> set) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                char c = sb.charAt(i);
                if (c != j) {
                    sb.setCharAt(i, j);
                    String ns = sb.toString();
                    if (set.contains(ns)) {
                        res.add(ns);
                    }
                    sb.setCharAt(i, c);
                }
            }
        }
        return res;
    }
}
