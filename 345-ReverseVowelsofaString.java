class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) return s;
        Set<Character> set = new HashSet<>();
        StringBuilder res = new StringBuilder(s);
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!set.contains(s.charAt(i))) {
                i++;
                continue;
            }
            if (!set.contains(s.charAt(j))) {
                j--;
                continue;
            }
            res.setCharAt(i, s.charAt(j));
            res.setCharAt(j, s.charAt(i));
            i++;
            j--;
        }
        return res.toString();
    }
}
