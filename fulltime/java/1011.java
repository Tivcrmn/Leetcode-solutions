class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int lo = 1, hi = 0;
        for (int weight : weights) {
            lo = Math.max(lo, weight);
            hi += weight;
        }
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            int days = getDays(mid, weights);
            if (days > D) lo = mid;
            else hi = mid;
        }
        return getDays(lo, weights) <= D ? lo : hi;
    }

    private int getDays(int totalWeights, int[] weights) {
        int days = 0;
        int curSize = 0;
        for (int weight : weights) {
            if (curSize + weight > totalWeights) {
                days++;
                curSize = weight;
            } else if (curSize + weight == totalWeights) {
                days++;
                curSize = 0;
            } else {
                curSize += weight;
            }
        }
        if (curSize > 0) days++;
        return days;
    }
}
