/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // traverse each list and get the number
        String num1 = getListNumber(l1);
        String num2 = getListNumber(l2);
        int minlength = Math.min(num1.length(), num2.length());
        int maxlength = Math.max(num1.length(), num2.length());
        int carry = 0;
        ListNode head = null;
        ListNode pre = null;
        ListNode cur = new ListNode(0);
        for (int i = 0; i < maxlength; i++) {
            int digit1 = 0;
            int digit2 = 0;
            if (num1.length() > num2.length()) {
                digit1 = num1.charAt(i) - '0';
                if ((i < minlength)) {
                    digit2 = num2.charAt(i) - '0';
                }
            } else {
                digit2 = num2.charAt(i) - '0';
                if ((i < minlength)) {
                    digit1 = num1.charAt(i) - '0';
                }
            }
            if (carry + digit1 + digit2 > 9) {
                cur.next = new ListNode(carry + digit1 + digit2 - 10);
                carry = 1;
            } else {
                cur.next = new ListNode(carry + digit1 + digit2);
                carry = 0;
            }
            if (i == 0) {
                head = cur.next;
            }
            cur = cur.next;
            pre = cur;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return head;
    }

    private String getListNumber(ListNode l) {
        int i = 0;
        String num = "";
        while (l != null) {
            num += l.val + "";
            l = l.next;
            i++;
        }
        return num;
    }
}
