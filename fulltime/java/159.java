class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int slow = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int fast = 0; fast < s.length(); fast++) {
            char fc = s.charAt(fast);
            map.put(fc, map.getOrDefault(fc, 0) + 1);
            while (map.size() > 2) {
                char sc = s.charAt(slow++);
                int num = map.get(sc);
                if (num == 1) {
                    map.remove(sc);
                } else {
                    map.put(sc, num - 1);
                }
            }
            max = Math.max(max, fast - slow + 1);
        }
        return max;
    }
}
