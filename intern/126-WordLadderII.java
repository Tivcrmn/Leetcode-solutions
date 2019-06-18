class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return new LinkedList<>();
        }
        if (!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        Map<String, Integer> map = new HashMap<>();
        Set<String> dictSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        Map<String, List<String>> nextWordsSet = new HashMap<>();

        // bfs from endWord to beginWord
        queue.offer(endWord);
        map.put(endWord, 0);
        int length = 0;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> nextWords = getNextWords(word, dictSet);
                nextWordsSet.put(word, nextWords);
                for (String nextWord : nextWords) {
                    if (map.get(nextWord) != null) {
                        continue;
                    }
                    queue.offer(nextWord);
                    map.put(nextWord, length);
                }
            }
        }

        // dfs from beginWord to endWord
        if (map.get(beginWord) == null) {
            return res;
        }
        list.add(beginWord);
        helper(res, new ArrayList<>(list), map.get(beginWord) - 1, map, nextWordsSet);
        return res;
    }

    private void helper(List<List<String>> res,
                        List<String> list,
                        int length,
                        Map<String, Integer> map,
                        Map<String, List<String>> nextWordsSet) {
        if (length < 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (String key : map.keySet()) {
                List<String> nextWords = nextWordsSet.get(list.get(list.size() - 1));
                Set<String> setWords = new HashSet<>(nextWords);
                if (map.get(key) == length && setWords.contains(key)) {
                    list.add(key);
                    helper(res, new ArrayList<>(list), length - 1, map, nextWordsSet);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
}
