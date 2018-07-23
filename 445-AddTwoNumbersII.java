class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num1 = listToString(l1);
        String num2 = listToString(l2);
        StringBuilder sum = new StringBuilder();
        int pos = 0;
        int carry = 0;
        while (pos < num1.length() || pos < num2.length()) {
            int digit1 = pos < num1.length() ? num1.charAt(num1.length() - 1 - pos) - '0' : 0;
            int digit2 = pos < num2.length() ? num2.charAt(num2.length() - 1 - pos) - '0' : 0;
            int digit = 0;
            if (digit1 + digit2 + carry > 9) {
                digit = digit1 + digit2 + carry - 10;
                carry = 1;
            } else {
                digit = digit1 + digit2 + carry;
                carry = 0;
            }
            pos++;
            sum.insert(0, "" + digit);
        }
        if (carry == 1) sum.insert(0, "1");
        ListNode res = stringToList(sum.toString());
        return res;
    }

    private String listToString(ListNode l) {
        String res = "";
        while (l != null) {
            res += l.val;
            l = l.next;
        }
        return res;
    }

    private ListNode stringToList(String s) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        int i = 0;
        while (i < s.length()) {
            res.next = new ListNode(s.charAt(i) - '0');
            i++;
            res = res.next;
        }
        return dummy.next;
    }
}
