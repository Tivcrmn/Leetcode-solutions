class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for (int house : houses) {
            int min = find(heaters, house);
            res = Math.max(res, min);
        }
        return res;
    }

    private int find(int[] heaters, int house) {
        int l = 0, r = heaters.length - 1;
        while (l + 1 < r) {
            int mid = (r - l) / 2 + l;
            if (heaters[mid] < house) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return Math.min(Math.abs(house - heaters[l]), Math.abs(house - heaters[r]));
    }
}
