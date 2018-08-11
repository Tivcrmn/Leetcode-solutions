class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets <= 1) return 0;
        int k = minutesToTest / minutesToDie + 1;
        int res = 1;
        while (buckets > Math.pow(k, res)) res++;
        return res;
    }
}
