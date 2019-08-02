class Solution {
    public int longestWPI(int[] hours) {
        int max = 0, diff = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) diff++;
            else diff--;
            hours[i] = diff;
            if (diff > 0) max = i + 1;
            else {
                if (!map.containsKey(diff)) {
                    map.put(diff, i);
                }
                Integer index = map.get(diff - 1);
                if (index != null) {
                    max = Math.max(max, i - index);
                }
            }
        }
        return max;
    }
}
