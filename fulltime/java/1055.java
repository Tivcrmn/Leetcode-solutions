class Solution {
    public int shortestWay(String source, String target) {
        int i = 0, j = 0, count = 0;
        boolean[] letters = new boolean[26];
        for (char c : source.toCharArray()) {
            letters[c - 'a'] = true;
        }
        while (j < target.length()) {
            if (!letters[target.charAt(j) - 'a']) return -1;
            if (source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else i++;
            if (i == source.length()) {
                i = 0;
                count++;
            }
        }
        if (i > 0) count++;
        return count;
    }
}
