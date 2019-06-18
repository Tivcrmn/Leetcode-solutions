/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        List<ListNode> copyLists = new ArrayList<>();
        for (ListNode n : lists) {
            copyLists.add(n);
        }
        return helper(copyLists);
    }

    private ListNode helper(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        } else if (lists.size() == 1) {
            return lists.get(0);
        } else if (lists.size() == 2) {
            return mergeTwoSortedArray(lists.get(0), lists.get(1));
        } else {
            int mid = lists.size() / 2;
            ListNode n1 = helper(lists.subList(0, mid + 1));
            ListNode n2 = helper(lists.subList(mid + 1, lists.size()));
            return mergeTwoSortedArray(n1, n2);
        }
    }

    private ListNode mergeTwoSortedArray(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (n1 != null || n2 != null) {
            if (n1 != null && n2 != null) {
                if (n1.val >= n2.val) {
                    head.next = new ListNode(n2.val);
                    head = head.next;
                    n2 = n2.next;
                } else {
                    head.next = new ListNode(n1.val);
                    head = head.next;
                    n1 = n1.next;
                }
            } else if (n1 == null) {
                head.next = new ListNode(n2.val);
                head = head.next;
                n2 = n2.next;
            } else {
                head.next = new ListNode(n1.val);
                head = head.next;
                n1 = n1.next;
            }
        }
        return dummy.next;
    }
}
