/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
    // recursively
    if (!head || !head.next) return head;
    const p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
};
