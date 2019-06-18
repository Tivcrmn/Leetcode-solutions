class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> list2 = new LinkedList<>();
        List<Integer> list3 = new LinkedList<>();
        List<Integer> list5 = new LinkedList<>();
        int res = 1;
        list2.add(2);
        list3.add(3);
        list5.add(5);
        for (int i = 1; i < n; i++) {
            res = Math.min(Math.min(list2.get(0), list3.get(0)), list5.get(0));
            if (res == list2.get(0)) list2.remove(0);
            if (res == list3.get(0)) list3.remove(0);
            if (res == list5.get(0)) list5.remove(0);
            list2.add(res * 2);
            list3.add(res * 3);
            list5.add(res * 5);
        }
        return res;
    }
}
