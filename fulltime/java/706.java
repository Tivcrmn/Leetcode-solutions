class MyHashMap {

    LinkedList<Pair>[] buckets;
    class Pair {
        int key;
        int val;
        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new LinkedList[1001];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucketIndex = key / 1000;
        LinkedList<Pair> list = buckets[bucketIndex];
        if (list == null) {
            buckets[bucketIndex] = new LinkedList<Pair>();
            list = buckets[bucketIndex];
        }
        for (int i = 0; i < list.size(); i++) {
            Pair p = list.get(i);
            if (p.key == key) {
                p.val = value;
                return;
            }
        }
        list.addFirst(new Pair(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucketIndex = key / 1000;
        LinkedList<Pair> list = buckets[bucketIndex];
        if (list == null) return -1;
        for (int i = 0; i < list.size(); i++) {
            Pair p = list.get(i);
            if (p.key == key) {
                return p.val;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucketIndex = key / 1000;
        LinkedList<Pair> list = buckets[bucketIndex];
        if (list == null) return;
        int removeIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            Pair p = list.get(i);
            if (p.key == key) {
                removeIndex = i;
                break;
            }
        }
        if (removeIndex != -1) {
            list.remove(removeIndex);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
