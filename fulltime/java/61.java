/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        if (k % len == 0) return head;
        int splitIndex = len - k % len - 1;
        ListNode splitNode = head;
        for (int i = 0; i < splitIndex; i++) {
            splitNode = splitNode.next;
        }
        tail.next = head;
        ListNode res = splitNode.next;
        splitNode.next = null;
        return res;
    }
}
