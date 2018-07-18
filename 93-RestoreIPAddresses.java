class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4) return res;
        helper(s, s.length(), 0, res, "");
        return res;
    }

    private void helper(String s, int remain, int part, List<String> res, String ip) {
        if (remain == 0 && part == 4) {
            res.add(ip.substring(0, ip.length() - 1));
        } else if (remain > 0 && part < 4) {
            String copyIp = ip;
            helper(s, remain - 1, part + 1, res,
               copyIp += s.substring(s.length() - remain, s.length() - remain + 1) + ".");
            copyIp = ip;
            if (remain > 1 && s.charAt(s.length() - remain) != '0')
            helper(s, remain - 2, part + 1, res,
               copyIp += s.substring(s.length() - remain, s.length() - remain + 2) + ".");
            copyIp = ip;
            if (remain > 2 &&
                s.charAt(s.length() - remain) != '0' &&
                valid(s.substring(s.length() - remain, s.length() - remain + 3)))
                helper(s, remain - 3, part + 1, res,
                        copyIp += s.substring(s.length() - remain, s.length() - remain + 3) + ".");
        }
    }

    private boolean valid(String ip) {
        int num = Integer.parseInt(ip);
        return num >= 0 && num <= 255;
    }
}
