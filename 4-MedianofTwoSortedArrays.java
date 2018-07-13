class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0;
        double res = 0;
        boolean even = (nums1.length + nums2.length) % 2 == 0;
        int discard = even ? (nums1.length + nums2.length) / 2 - 1 : (nums1.length + nums2.length) / 2;

        while (discard != 0) {
            int temp = discard == 1 ? 1 : discard / 2;
            if (p1 + temp > nums1.length) {
                p2 += temp;
            } else if (p2 + temp > nums2.length) {
                p1 += temp;
            } else {
                if (nums1[p1 + temp - 1] >= nums2[p2 + temp - 1]) {
                    if (p2 + temp >= nums2.length) {
                        p1 += p2 + temp - nums2.length;
                        p2 = nums2.length;
                    } else {
                        p2 += temp;
                    }
                } else {
                    if (p1 + temp >= nums1.length) {
                        p2 += p1 + temp - nums1.length;
                        p1 = nums1.length;
                    } else {
                        p1 += temp;
                    }
                }
            }
            discard -= temp;
        }

        if (p1 == nums1.length) {
            res = even ? ((double)nums2[p2] + (double)nums2[p2 + 1]) / 2 : nums2[p2];
        } else if (p2 == nums2.length) {
            res = even ? ((double)nums1[p1] + (double)nums1[p1 + 1]) / 2: nums1[p1];
        } else {
            double min1 = 0, min2 = 0;
            if (nums1[p1] >= nums2[p2]) {
                min1 = nums2[p2];
                min2 = Math.min(nums1[p1], p2 + 1 < nums2.length ? nums2[p2 + 1] : Integer.MAX_VALUE);
            } else {
                min1 = nums1[p1];
                min2 = Math.min(p1 + 1 < nums1.length ? nums1[p1 + 1] : Integer.MAX_VALUE, nums2[p2]);
            }
            if (!even) res = min1;
            else res = (min1 + min2) / 2;
        }
        return res;

    }
}
