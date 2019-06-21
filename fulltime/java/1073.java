class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int p1 = arr1.length - 1, p2 = arr2.length - 1, carry = 0;
        List<Integer> list = new ArrayList<>();
        while (p1 >= 0 || p2 >= 0 || carry != 0) {
            int sum = (p1 >= 0 ? arr1[p1--] : 0) + (p2 >= 0 ? arr2[p2--] : 0) + carry;
            int res = sum & 1;
            carry = -1 * (sum >> 1);
            list.add(res);
        }
        int beginIndex = list.size() - 1;
        while (beginIndex >= 0 && list.get(beginIndex) == 0) beginIndex--;
        if (beginIndex < 0) return new int[]{0};
        int[] res = new int[beginIndex + 1];
        for (int i = beginIndex; i >= 0; i--) {
            res[beginIndex - i] = list.get(i);
        }
        return res;
    }
}

/**
sum = 0 -> carry = 0, result = 0
sum = 1 -> carry = 0, result = 1
sum = 2 -> carry = -1, result = 0
sum = 3 -> carry = -1, result = 1
sum = -1 -> carry = 1, result = 1

carry = -1 * (sum >> 1)
result = sum & 1
**/
