class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char res = ' ';
        for (char ch : s.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                map.put(ch, count + 1);
            }
        }
        for (char ch : t.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null || count == 0) {
                res = ch;
                break;
            } else {
                map.put(ch, count - 1);
            }
        }
        return res;

    }
}
