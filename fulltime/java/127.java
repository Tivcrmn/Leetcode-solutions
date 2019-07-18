class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return count;
                List<String> nextWords = getNextWords(word, wordSet);
                for (String nextWord : nextWords) {
                    if (!visited.contains(nextWord)) {
                        visited.add(nextWord);
                        queue.offer(nextWord);
                    }
                }
            }
        }
        return 0;
    }

    private List<String> getNextWords(String word, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            char c = sb.charAt(i);
            for (int j = 0; j < 26; j++) {
                if (j == c - 'a') continue;
                sb.setCharAt(i, (char)(97 + j));
                String cur = sb.toString();
                if (wordSet.contains(cur)) {
                    res.add(cur);
                }
            }
            sb.setCharAt(i, c);
        }
        return res;
    }
}
