class MyLinkedList {

    /** Initialize your data structure here. */
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    int size;
    Node f;
    public MyLinkedList() {
        size = 0;
        f = new Node(-1);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size) return -1;
        Node res = getNthNode(index);
        return res.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = f.next;
        f.next = n;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node n = new Node(val);
        Node tailPre = getNthNode(size - 1);
        tailPre.next = n;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        Node n = new Node(val);
        Node pre = getNthNode(index - 1);
        n.next = pre.next;
        pre.next = n;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node pre = getNthNode(index - 1);
        pre.next = pre.next.next;
        size--;
    }

    private Node getNthNode(int n) {
        Node cur = f;
        for (int i = 0; i <= n; i++) {
            cur = cur.next;
        }
        return cur;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
