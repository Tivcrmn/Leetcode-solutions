/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> nums1 = new ArrayList<>();
        List<Integer> nums2 = new ArrayList<>();
        while (l1 != null) {
            nums1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            nums2.add(l2.val);
            l2 = l2.next;
        }
        ListNode cur = null;
        int carry = 0;
        int p1 = nums1.size() - 1, p2 = nums2.size() - 1;
        while (p1 >= 0 || p2 >= 0 || carry != 0) {
            int d1 = p1 >= 0 ? nums1.get(p1--) : 0;
            int d2 = p2 >= 0 ? nums2.get(p2--) : 0;
            int sum = d1 + d2 + carry;
            ListNode head = new ListNode(sum % 10);
            head.next = cur;
            cur = head;
            carry = sum / 10;
        }
        return cur;
    }
}
