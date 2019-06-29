/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // space O(k) easy to understand
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> st = new Stack<>();
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        while (head != null) {
            for (int i = 0; i < k && head != null; i++) {
                st.push(head);
                head = head.next;
            }
            if (st.size() < k) return dummy.next;
            while (!st.isEmpty()) {
                cur.next = st.pop();
                cur = cur.next;
            }
            cur.next = head;
        }
        return dummy.next;
    }
}

class Solution {
    // space O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while (head != null) {
            head = reverseNextKNode(head, k);
        }

        return dummy.next;
    }

    private ListNode reverseNextKNode(ListNode head, int k) {
        // head is the previous node of the first node which needs to be reversed
        // if return is null, which means the number of remain nodes is less than k
        ListNode n1 = head.next;
        ListNode nk = head;
        for (int i = 0; i < k; i++) {
            nk = nk.next;
            if (nk == null) return null;
        }
        ListNode nkNext = nk.next;
        ListNode pre = null;
        ListNode cur = n1;
        while (cur != nkNext) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        head.next = nk;
        n1.next = nkNext;
        return n1;
    }
}
