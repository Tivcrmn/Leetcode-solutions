/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0), pre = dummy, cur = head;
        dummy.next = head;
        int copym = m;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        ListNode preHead = null, curHead = cur;
        for (int i = 0; i <= n - m; i++) {
            ListNode nextCur = curHead.next;
            curHead.next = preHead;
            preHead = curHead;
            curHead = nextCur;
        }
        pre.next = preHead;
        cur.next = curHead;
        return dummy.next;
    }
}
