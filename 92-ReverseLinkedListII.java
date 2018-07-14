class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return head;
        ListNode copy_head = head;
        int count = 1;
        ListNode m_prev = null;
        ListNode m_node = null;
        ListNode head_prev = null;
        if (m == 1) {
            m_node = head;
            head_prev = m_node;
        } else {
            while (count != m - 1) {
                head = head.next;
                count++;
            }
            count++;
            m_prev = head;
            m_node = head.next;
            head_prev = m_node;
        }
        head = head_prev.next;

        while (count != n) {
            ListNode temp = head.next;
            head.next = head_prev;
            head_prev = head;
            head = temp;
            count++;
        }
        if (m != 1) m_prev.next = head_prev;
        m_node.next = head;
        return m == 1 ? head_prev : copy_head;
    }
}
