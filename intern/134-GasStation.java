class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int remain = 0;
        int debt = 0;
        for (int i = 0; i < gas.length; i++) {
            remain += gas[i] - cost[i];
            if (remain < 0) {
                start = i + 1;
                debt += remain;
                remain = 0;
            }
        }
        return remain + debt >= 0 ? start : -1;
    }
}
