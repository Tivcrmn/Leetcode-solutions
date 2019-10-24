import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*
[1, 2, 2, 3, 1, 4, 5]
*/


class Solution {
  static private int process(int[] nums, int k) {
    int n = nums.length;
    int[] leftSum = new int[n], rightSum = new int[n];
    Arrays.fill(leftSum, n + 1);
    Arrays.fill(rightSum, n + 1);
    Map<Integer, Integer> map = new HashMap<>();

    int sum = 0;
    map.put(0, -1);
    for (int i = 0; i < n; i++) {
      sum += nums[i];
      if (map.containsKey(sum - k)) {
        leftSum[i] = i - map.get(sum - k);
      }
      if (i > 0) leftSum[i] = Math.min(leftSum[i - 1], leftSum[i]);
      map.put(sum, i);
    }

    sum = 0;
    map.clear();
    map.put(0, n);

    for (int i = n - 1; i >= 0; i--) {
      sum += nums[i];
      if (map.containsKey(sum - k)) {
        rightSum[i] = map.get(sum - k) - i;
      }
      if (i < n - 1) rightSum[i] = Math.min(rightSum[i + 1], rightSum[i]);
    }

    int min = n + 1;
    for (int i = 0; i < n - 1; i++) {
      min = Math.min(leftSum[i] + rightSum[i], min);
    }
    return min;
  }
  public static void main(String[] args) {
    System.out.println(process(new int[]{1, 2, 2, 3, 1, 4, 5}, 5));
  }
}
