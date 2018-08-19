class LRUCache {
    class Node {
        Node prev;
        Node next;
        int val;
        int key;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    Map<Integer, Node> map;
    Node f;
    Node r;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        f = new Node(0, 0);
        r = new Node(0, 0);
        f.next = r;
        r.prev = f;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            if (cur.next != r) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                moveToRear(cur);
            }
            return cur.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        if (capacity == map.size()) {
            map.remove(f.next.key);
            f.next = f.next.next;
            f.next.prev = f;
        }
        Node n = new Node(key, value);
        map.put(key, n);
        moveToRear(n);
    }

    private void moveToRear(Node cur) {
        cur.prev = r.prev;
        r.prev.next = cur;
        cur.next = r;
        r.prev = cur;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
