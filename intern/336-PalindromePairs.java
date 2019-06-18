class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                if (isPalindrome(s1)) {
                    String sr2 = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(sr2) && map.get(sr2) != i) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(map.get(sr2));
                        pair.add(i);
                        res.add(pair);
                    }
                }
                if (isPalindrome(s2) && s2.length() != 0) {
                    String sr1 = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(sr1) && map.get(sr1) != i) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(map.get(sr1));
                        res.add(pair);
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
