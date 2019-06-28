/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0), pre = null, cur = dummy;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                pre = head.next;
                head = head.next.next;
            } else if (pre == null || head.val != pre.val) {
                cur.next = head;
                pre = head;
                head = head.next;
                cur = cur.next;
            } else {
                pre = head;
                head = head.next;
            }
        }
        cur.next = null;
        if (head != null && (pre == null || head.val != pre.val)) {
            cur.next = head;
        }
        return dummy.next;
    }
}
