class Solution {
    public boolean isPalindrome(String s) {
        // A-Z 65-90 a-z 97-122 0-9 48-57
        if (s == null || s.length() == 0) {
            return true;
        }

        int i = 0, j = s.length() - 1;
        String str = s.toLowerCase();
        while (i <= j) {
            if (!isAlphanumeric(str.charAt(i))) {
                i++;
            } else if  (!isAlphanumeric(str.charAt(j))) {
                j--;
            } else if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isAlphanumeric (char s) {
        int ascii = (int)s;
        // if (ascii >= 65 && ascii <= 90) {
        //     return true;
        // }
        if (ascii >= 97 && ascii <= 122) {
            return true;
        }
        if (ascii >= 48 && ascii <= 57) {
            return true;
        }
        return false;
    }
}
