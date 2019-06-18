class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return helper(input);
    }

    private List<Integer> helper(String s) {
        List<Integer> res = new ArrayList<>();
        if (s.indexOf('-') == -1 && s.indexOf('+') == -1 && s.indexOf('*') == -1) res.add(Integer.parseInt(s));
        else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '-' || s.charAt(i) == '+' || s.charAt(i) == '*') {
                    List<Integer> left = helper(s.substring(0, i));
                    List<Integer> right = helper(s.substring(i + 1));
                    for (int l : left) {
                        for (int r : right) {
                            switch (s.charAt(i)) {
                                case '-' : res.add(l - r); break;
                                case '+' : res.add(l + r); break;
                                case '*' : res.add(l * r); break;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
