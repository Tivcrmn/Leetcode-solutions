class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        String[] digitString = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits.length() == 0) {
            return results;
        }
        results.add("");
        for (int i = 0; i < digits.length(); i++) {
            results = extend(digitString[digits.charAt(i) - '1'], results);
        }
        return results;
    }

    private List<String> extend(String digits, List<String> results) {
        List<String> extendResults = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            for (String result : results) {
                extendResults.add(result + digits.charAt(i));
            }
        }
        return extendResults;
    }
}
