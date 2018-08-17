class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int slow = 0, fast = 0, index = 0, minLen = Integer.MAX_VALUE, matchCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) map.put(ch, 1);
            else map.put(ch, count + 1);
        }
        for (; fast < s.length(); fast++) {
            Integer count = map.get(s.charAt(fast));
            if (count == null) {
                continue;
            }
            map.put(s.charAt(fast), count - 1);
            if (count == 1) matchCount++;
            while (matchCount == map.size()) {
                if (fast - slow + 1 < minLen) {
                    minLen = fast - slow + 1;
                    index = slow;
                }
                Integer leftmost = map.get(s.charAt(slow++));
                if (leftmost == null) {
                    continue;
                } else {
                    map.put(s.charAt(slow - 1), leftmost + 1);
                }
                if (leftmost == 0) matchCount--;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);
    }
}
