class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(convert(email));
        }
        return set.size();
    }

    private String convert(String email) {
        String[] splits = email.split("@");
        StringBuilder sb = new StringBuilder();
        for (char c : splits[0].toCharArray()) {
            if (c == '+') break;
            else if (c == '.') continue;
            else {
                sb.append(c + "");
            }
        }
        sb.append("@");
        sb.append(splits[1]);
        return sb.toString();
    }
}
