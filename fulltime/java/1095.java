/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // code is long, but it is clear, beat 100%.....
        int lo = 0, hi = mountainArr.length() - 1;
        int len = mountainArr.length();
        int pivot = -1;
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            int pre = mountainArr.get(mid - 1);
            int cur = mountainArr.get(mid);
            int nex = mountainArr.get(mid + 1);
            if (cur < nex) {
                lo = mid + 1;
            } else if (cur < pre) {
                hi = mid - 1;
            } else {
                pivot = mid;
                break;
            }
        }
        if (pivot == -1) {
            pivot = mountainArr.get(lo) < mountainArr.get(hi) ? hi : lo;
        }
        if (mountainArr.get(pivot) == target) return pivot;
        int index1 = binarySearchIncrease(target, mountainArr, 0, pivot - 1);
        if (index1 != -1) return index1;
        int index2 = binarySearchDecrease(target, mountainArr, pivot + 1, len - 1);
        if (index2 != -1) return index2;
        return -1;
    }

    private int binarySearchIncrease(int target, MountainArray mountainArr, int lo, int hi) {
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            int cur = mountainArr.get(mid);
            if (cur < target) lo = mid;
            else hi = mid;
        }
        if (mountainArr.get(lo) == target) return lo;
        if (mountainArr.get(hi) == target) return hi;
        return -1;
    }

    private int binarySearchDecrease(int target, MountainArray mountainArr, int lo, int hi) {
        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            int cur = mountainArr.get(mid);
            if (cur < target) hi = mid;
            else lo = mid;
        }
        if (mountainArr.get(lo) == target) return lo;
        if (mountainArr.get(hi) == target) return hi;
        return -1;
    }
}
