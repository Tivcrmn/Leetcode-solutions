class Solution {
    Set<String> wordSet;
    List<List<String>> res;
    Map<String, Integer> map;
    Map<String, List<String>> nextWordsSet;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        wordSet = new HashSet<>(wordList);
        res = new ArrayList<>();
        if (!wordSet.contains(endWord)) return res;
        if (!wordList.contains(beginWord)) {
            wordSet.add(beginWord);
        }
        // bfs to find the shortest length
        Queue<String> queue = new LinkedList<>();
        map = new HashMap<>();
        nextWordsSet = new HashMap<>();
        int len = 0;
        queue.offer(endWord);
        map.put(endWord, 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            len++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                List<String> nextWords = getNextWords(cur, wordSet);
                nextWordsSet.put(cur, nextWords);
                for (String next : nextWords) {
                    if (!map.containsKey(next)) {
                        queue.offer(next);
                        map.put(next, len);
                    }
                }
            }
        }

        if (!map.containsKey(beginWord)) return res;
        // dfs with pruning
        List<String> ans = new ArrayList<>();
        ans.add(beginWord);
        dfs(map.get(beginWord) - 1, ans);
        return res;
    }

    private void dfs(int len,
                     List<String> ans) {
        if (len < 0) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (String key : map.keySet()) {
            List<String> nextWords = nextWordsSet.get(ans.get(ans.size() - 1));
            Set<String> setWords = new HashSet<>(nextWords);
            if (map.get(key) == len && setWords.contains(key)) {
                ans.add(key);
                dfs(len - 1, new ArrayList<>(ans));
                ans.remove(ans.size() - 1);
            }
        }
    }

    private List<String> getNextWords(String s, Set<String> set) {
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
