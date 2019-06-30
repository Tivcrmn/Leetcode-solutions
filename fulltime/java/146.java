class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node f;
    Node r;
    int capacity;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        f = new Node(-1, -1);
        r = new Node(-1, -1);
        f.next = r;
        r.prev = f;
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node n = map.get(key);
        if (n.next != r) {
            n.next.prev = n.prev;
            n.prev.next = n.next;
            moveToRear(n);
        }
        return n.val;
    }

    public void put(int key, int value) {
        Node n = null;
        if (map.containsKey(key)) {
            n = map.get(key);
            n.val = value;
            if (n.next != r) {
                n.next.prev = n.prev;
                n.prev.next = n.next;
                moveToRear(n);
            }
        } else {
            if (map.size() == capacity) {
                Node remove = map.get(f.next.key);
                map.remove(f.next.key);
                f.next = f.next.next;
                f.next.prev = f;
            }
            n = new Node(key, value);
            map.put(key, n);
            moveToRear(n);
        }
    }

    private void moveToRear(Node n) {
        n.next = r;
        n.prev = r.prev;
        r.prev.next = n;
        r.prev = n;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
