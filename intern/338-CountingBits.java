class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        if (num > 0) {
            res[1] = 1;
        }
        int round = 0;
        while (num >= 2 << round) {
            round++;
        }
        for (int i = 0; i < round; i++) {
            int halfNums = 1 << i;
            int prevStart = 1 << i;
            int curStart = 1 << (i + 1);
            if (i < round - 1) {
                for (int j = 0; j < halfNums; j++) {
                    res[curStart + j] = res[prevStart + j];
                    res[curStart + halfNums + j] = res[prevStart + j] + 1;
                }
            } else if (i == round - 1) {
                int remainNums = num - curStart + 1;
                if (remainNums <= halfNums) {
                    for (int j = 0; j < remainNums; j++) {
                        res[curStart + j] = res[prevStart + j];
                    }
                } else {
                    for (int j = 0; j < halfNums; j++) {
                        res[curStart + j] = res[prevStart + j];
                    }
                    for (int j = 0; j < remainNums - halfNums; j++) {
                        res[curStart + halfNums + j] = res[prevStart + j] + 1;
                    }
                }
            }
        }
        return res;
    }
}
