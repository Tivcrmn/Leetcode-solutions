/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        RandomListNode cloneHead = head;
        while (cloneHead != null) {
            RandomListNode node = new RandomListNode(cloneHead.label);
            node.next = cloneHead.next;
            cloneHead.next = node;
            cloneHead = node.next;
        }
        cloneHead = head;
        while (cloneHead != null) {
            if (cloneHead.random != null) {
                cloneHead.next.random = cloneHead.random.next;
            }
            cloneHead = cloneHead.next.next;
        }
        cloneHead = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode prev = dummy;
        while (cloneHead != null) {
            prev.next = cloneHead.next;
            cloneHead.next = cloneHead.next.next;
            prev = prev.next;
            cloneHead = cloneHead.next;
        }
        return dummy.next;
    }
}
