class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int res = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        for (int house : houses) {
            int min = binarySearch(heaters, house);
            res = Math.max(res, min);
        }
        return res;
    }

    private int binarySearch(int[] heaters, int target) {
        int left = 0, right = heaters.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (heaters[mid] < target) left = mid;
            else if (heaters[mid] == target) return 0;
            else right = mid;
        }
        return Math.min(Math.abs(target - heaters[left]), Math.abs(target - heaters[right]));
    }
}
