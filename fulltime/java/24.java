/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0), cur = dummy;
        ListNode nextHead = null;
        while (head != null && head.next != null) {
            nextHead = head.next.next;
            cur.next = head.next;
            cur.next.next = head;
            head.next = null;
            head = nextHead;
            cur = cur.next.next;
        }
        if (head != null) {
            cur.next = head;
        }
        return dummy.next;
    }
}
