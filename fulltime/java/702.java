class Solution {
    public int search(ArrayReader reader, int target) {
        int len = 1;
        while (true) {
            int num = reader.get(len);
            if (num < target) len *= 2;
            else break;
        }
        int lo = 0, hi = len;
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            int num = reader.get(mid);
            if (num == target) return mid;
            else if (num < target) lo = mid + 1;
            else hi = mid - 1;
        }
        if (reader.get(lo) == target) return lo;
        if (reader.get(hi) == target) return hi;
        return -1;
    }
}
