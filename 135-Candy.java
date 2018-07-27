class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        int[] candys = new int[ratings.length];
        int count = 0;
        Arrays.fill(candys, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) candys[i] = candys[i - 1] + 1;
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) candys[i] = Math.max(candys[i], candys[i + 1] + 1);
        }
        for (int candy : candys) {
            count += candy;
        }
        return count;
    }
}
