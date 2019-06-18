class Solution {
    public int nextGreaterElement(int n) {
        String num = n + "";
        for (int i = num.length() - 1; i > 0; i--) {
            if (num.charAt(i) <= num.charAt(i - 1)) continue;
            else {
                int index = i - 1;
                while (i < num.length() && num.charAt(i) > num.charAt(index)) i++;
                StringBuilder sb = new StringBuilder(num);
                sb.setCharAt(index, num.charAt(i - 1));
                sb.setCharAt(i - 1, num.charAt(index));
                char[] chs = sb.toString().substring(index + 1).toCharArray();
                Arrays.sort(chs);
                String res = sb.toString().substring(0, index + 1);
                for (char ch : chs) {
                    res += ch;
                }
                try {
                    return Integer.parseInt(res);
                } catch (Exception e) {
                    return -1;
                }
            }
        }
        return -1;
    }
}
