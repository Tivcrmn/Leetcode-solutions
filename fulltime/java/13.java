class Solution {
    public int romanToInt(String s) {
        int res = 0;
        res += convert(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int curNum = convert(s.charAt(i));
            int preNum = convert(s.charAt(i - 1));
            if (curNum > preNum) {
                res -= 2 * preNum;
            }
            res += curNum;
        }
        return res;
    }

    private int convert(char c) {
        int res = 0;
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return res;
    }
}
