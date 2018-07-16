class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return people;
        }
        int[][] res = new int[people.length][2];
        for (int[] item : res) {
            item[0] = -1;
        }
        people = mergeSort(people, 0, people.length - 1);
        for (int i = 0; i < people.length; i++) {
            int num = people[i][1];
            for (int j = 0; j < res.length; j++) {
                if (res[j][0] == -1) num--;
                if (num == -1) {
                    res[j] = people[i];
                    break;
                }
            }
        }
        return res;
    }

    private int[][] mergeSort(int[][] nums, int start, int end) {
        int[][] res = new int[end - start + 1][2];
        if (start == end) {
            res[0] = nums[start];
        } else if (start + 1 == end) {
            res = comparePeople(nums[start], nums[end]);
        } else {
            int mid = (start + end) / 2;
            int count = 0;
            int i = 0;
            int j = 0;
            int[][] left = mergeSort(nums, start, mid);
            int[][] right = mergeSort(nums, mid + 1, end);
            while (i < left.length && j < right.length) {
                res[count] = comparePeople(left[i], right[j])[0];
                if (left[i] == res[count]) i++;
                else j++;
                count++;
            }
            while (i < left.length) {
                res[count] = left[i];
                i++;
                count++;
            }
            while (j < right.length) {
                res[count] = right[j];
                j++;
                count++;
            }
        }
        return res;
    }

    private int[][] comparePeople(int[] a, int[] b) {
        if (a[0] > b[0]) {
            return new int[][]{b, a};
        } else if (a[0] < b[0]) {
            return new int[][]{a, b};
        } else if (a[1] > b[1]) {
            return new int[][]{a, b};
        } else if (a[1] <= b[1]) {
            return new int[][]{b, a};
        }
        return new int[][]{};
    }
}
