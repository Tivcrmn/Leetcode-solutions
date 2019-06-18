class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        helper(num, "", 0, res);
        return res;
    }

    private void helper(int num, String res, int index, List<String> resList) {
        if (index == 10) {
            if (num == 0) {
                int[] time = getTime(res);
                if (time[0] < 12 && time[1] < 60) resList.add(time[1] < 10 ? time[0] + ":0" + time[1] : time[0] + ":" + time[1]);
                else return;
            } else {
                return;
            }
        } else {
            helper(num - 1, res + "1", index + 1, resList);
            helper(num, res + "0", index + 1, resList);
        }
    }

    private int[] getTime(String res) {
        int hour = 0;
        int min = 0;
        String time = "";
        for (int i = 0; i < 10; i++) {
           if (i < 4) {
               hour += (res.charAt(i) - '0') << (3 - i);
           } else {
               min += (res.charAt(i) - '0') << (9 - i);
           }
        }
        return new int[]{hour, min};
    }
}
