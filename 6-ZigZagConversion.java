class Solution {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return new String("");
        }
        if (numRows == 1) {
            return s;
        }
        String[] subString = new String[numRows];
        for (int j = 0; j < subString.length; j++) {
            subString[j] = new String("");
        }
        String result = new String("");
        for (int i = 0; i < s.length(); i++) {
            int index = i % (2 * numRows - 2);
            if (index < numRows) {
                subString[index] += s.charAt(i);
            } else {
                subString[2 * numRows - index - 2] += s.charAt(i);
            }
        }
        for (int j = 0; j < subString.length; j++) {
            result += subString[j];
        }
        return result;
    }
}
