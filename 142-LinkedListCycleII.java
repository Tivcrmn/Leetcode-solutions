public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            fast = fast.next;
            if (slow.next == null || slow.next.next == null) {
                return null;
            } else {
                slow = slow.next.next;
            }
            if (fast == slow) {
                break;
            }
        }
        while (true) {
            if (head == fast) {
                break;
            } else {
                head = head.next;
                fast = fast.next;
            }
        }
        return fast;
    }
}
