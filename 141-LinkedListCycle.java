public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (slow != null) {
            fast = fast.next;
            if (slow.next == null) {
                break;
            } else if (slow.next.next == null) {
                break;
            } else {
                slow = slow.next.next;
            }
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
