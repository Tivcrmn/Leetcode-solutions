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
        ListNode slow = head, fast = head, slowPre = null;
        while (fast != null && fast.next != null) {
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode half = reverse(slow);
        slowPre.next = null;
        ListNode dummy = new ListNode(0), cur = dummy;
        while (head != null && half != null) {
            cur.next = head;
            head = head.next;
            cur.next.next = half;
            half = half.next;
            cur = cur.next.next;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
