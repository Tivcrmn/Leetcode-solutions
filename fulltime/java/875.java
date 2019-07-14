class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1, hi = 0;
        for (int pile : piles) {
            hi = Math.max(hi, pile);
        }
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            int hours = getHours(mid, piles);
            // hours >= H is wrong
            if (hours > H) lo = mid;
            else hi = mid;
        }
        return getHours(lo, piles) <= H ? lo : hi;
    }

    private int getHours(int preHour, int[] piles) {
        int hours = 0;
        for (int pile : piles) {
            hours += (int)Math.ceil((double)pile / (double)preHour);
        }
        return hours;
    }
}
