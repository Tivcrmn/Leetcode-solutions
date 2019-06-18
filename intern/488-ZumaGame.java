class Solution {
    public int findMinStep(String board, String hand) {
        int[] map = new int[5];
        for (char ch : hand.toCharArray()) {
            map[reflect(ch)]++;
        }
        return helper(board, map);
    }

    private int helper(String board, int[] map) {
        if (board.length() == 0) return 0;
        int i = 0;
        int j = 0;
        int ans = Integer.MAX_VALUE;
        while (i < board.length()) {
            while (j < board.length() && board.charAt(i) == board.charAt(j)) j++;
            char color = board.charAt(i);
            int num = 3 - (j - i);
            if (map[reflect(color)] >= num) {
                String ns = shrink(board.substring(0, i) + board.substring(j));
                map[reflect(color)] -= num;
                int res = helper(ns, map);
                if (res >= 0) ans = Math.min(ans, res + num);
                map[reflect(color)] += num;
            }
            i = j;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private String shrink(String s) {
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) j++;
            if (j - i >= 3) {
                s = s.substring(0, i) + s.substring(j);
                i = 0;
            } else {
                i++;
            }
        }
        return s;
    }

    private int reflect(char c) {
        int index = 0;
        switch(c) {
            case 'R': index = 0; break;
            case 'Y': index = 1; break;
            case 'B': index = 2; break;
            case 'G': index = 3; break;
            case 'W': index = 4; break;
        }
        return index;
    }
}
