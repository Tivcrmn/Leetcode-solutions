/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow.next;
        ListNode pre = null;
        slow.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode f_h = head;
        ListNode s_h = pre;
        while (f_h != null && s_h != null) {
            ListNode f_h_next = f_h.next;
            ListNode s_h_next = s_h.next;
            f_h.next = s_h;
            s_h.next = f_h_next;
            f_h = f_h_next;
            s_h = s_h_next;
        }
    }
}
