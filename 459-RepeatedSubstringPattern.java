class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        boolean match = false;
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                int repeat = len / i;
                for (int j = 1; j < repeat; j++) {
                    if (!s.substring((j - 1) * i, j * i).equals(s.substring(j * i, (j + 1) * i))) {
                        match = false;
                        break;
                    } else {
                        match = true;
                    }
                }
                if (match) return true;
            }
        }
        return false;
    }
}
