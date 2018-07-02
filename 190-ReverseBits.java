public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        boolean[] bits = new boolean[32];
        int res = 0;
        for (int i = 0; i < 32; i++) {
            bits[i] = (n >> i & 1) == 1;
            res += (bits[i] ? 1 : 0) << (31 - i);
        }
        return res;
    }
}
