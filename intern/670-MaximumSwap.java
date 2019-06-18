class Solution {
    public int maximumSwap(int num) {
        StringBuilder res = new StringBuilder(num + "");
        String str = num + "";
        int max = -1;
        int pos = str.length() - 1;
        int[] maxAfter = new int[str.length()];
        int[] maxPos = new int[str.length()];
        Arrays.fill(maxAfter, -1);
        for (int i = str.length() - 2; i >= 0; i--) {
            if (str.charAt(i + 1) - '0' > max) {
                max = str.charAt(i + 1) - '0';
                pos = i + 1;
            }
            if (max > str.charAt(i) - '0') {
                maxAfter[i] = max;
                maxPos[i] = pos;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (maxAfter[i] > str.charAt(i) - '0') {
                res.setCharAt(maxPos[i], str.charAt(i));
                res.setCharAt(i, (char)(maxAfter[i] + 48));
                break;
            }
        }
        return Integer.parseInt(res.toString());
    }
}
