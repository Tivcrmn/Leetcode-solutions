class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        Set<String> dictSet = new HashSet<>(wordList);
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        set.add(beginWord);
        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> nextWords = getNextWords(word, dictSet);
                for (String nextWord : nextWords) {
                    if (set.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(endWord)) {
                        return length;
                    }
                    queue.offer(nextWord);
                    set.add(nextWord);
                }
            }
        }

        return 0;
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
