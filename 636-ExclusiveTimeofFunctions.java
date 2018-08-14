// not working now...
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<String> s = new Stack<>();
        String prev = null;
        for (String log : logs) {
            if (s.isEmpty()) s.push(log);
            else {
                if (getId(s.peek()) == getId(log)) {
                    if (getStatus(s.peek()).equals("start") && getStatus(log).equals("end")) {
                        if (prev == null) {
                            res[getId(log)] += getTime(log) - getTime(s.peek()) + 1;
                            s.pop();
                            prev = log;
                        } else {
                            res[getId(log)] += getTime(log) - getTime(prev);
                            s.pop();
                            prev = null;
                        }
                    } else {
                        res[getId(log)] += getTime(log) - getTime(s.peek());
                        s.push(log);
                    }
                } else {
                    if (prev == null) {
                        res[getId(log)] += getTime(log) - getTime(s.peek());
                        prev = log;
                    } else {
                        res[getId(log)] += getTime(log) - getTime(prev) - 1;
                        prev = null;
                    }
                    s.push(log);
                }
            }
        }
        return res;
    }

    private int getId(String s) {
        return Integer.parseInt(s.substring(0, s.indexOf(":")));
    }

    private int getTime(String s) {
        return Integer.parseInt(s.substring(s.lastIndexOf(":") + 1));
    }

    private String getStatus(String s) {
        return s.substring(s.indexOf(":") + 1, s.lastIndexOf(":"));
    }
}
