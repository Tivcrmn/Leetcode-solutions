class Solution {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "";
        }
        String[] labels = new String[]{"IVX", "XLC", "CDM"};
        String ans = new String("");
        String str = "" + num;
        if (str.length() == 4) {
            ans = getDigitStr('M', str.charAt(0) - '0');
            str = str.substring(1);
        }
        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            if (digit < 4) {
                ans += getDigitStr(labels[str.length() - 1 - i].charAt(0), digit);
            } else if (digit == 4) {
                ans += labels[str.length() - 1 - i].substring(0, 2);
            } else if (digit < 9) {
                ans += labels[str.length() - 1 - i].charAt(1);
                ans += getDigitStr(labels[str.length() - 1 - i].charAt(0), digit - 5);
            } else {
                ans += labels[str.length() - 1 - i].charAt(0);
                ans += labels[str.length() - 1 - i].charAt(2);
            }
        }
        return ans;
    }

    private String getDigitStr(char label, Integer repeat) {
        String ans = "";
        for (int i = 0; i < repeat; i++) {
            ans+=label;
        }
        return ans;
    }
}
