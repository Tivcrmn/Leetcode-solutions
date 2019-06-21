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
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                cur.next = head;
                cur = cur.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
