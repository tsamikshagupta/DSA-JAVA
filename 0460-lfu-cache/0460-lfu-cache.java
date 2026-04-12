class LFUCache {
    class Node {
        int key, value, freq;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
    class DLL {
        Node head, tail;
        int size;
        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }
        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        Node removeLast() {
            if (size > 0) {
                Node last = tail.prev;
                remove(last);
                return last;
            }
            return null;
        }
    }
    private int capacity, minFreq;
    private Map<Integer, Node> map;
    private Map<Integer, DLL> freqMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (map.size() == capacity) {
                DLL minList = freqMap.get(minFreq);
                Node toRemove = minList.removeLast();
                map.remove(toRemove.key);
            }

            Node newNode = new Node(key, value);
            minFreq = 1;
            DLL list = freqMap.getOrDefault(1, new DLL());
            list.addFirst(newNode);
            freqMap.put(1, list);
            map.put(key, newNode);
        }
    }

    private void updateFreq(Node node) {
        int freq = node.freq;
        DLL list = freqMap.get(freq);
        list.remove(node);
        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }
        node.freq++;
        DLL newList = freqMap.getOrDefault(node.freq, new DLL());
        newList.addFirst(node);
        freqMap.put(node.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */