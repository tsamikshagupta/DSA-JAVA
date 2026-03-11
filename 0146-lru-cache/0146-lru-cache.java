class LRUCache {
    int cap;
    Map<Integer , Integer> map;
    List<Integer> list;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        list = new ArrayList<>();
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        list.remove((Integer) key);
        list.add(key);
        return map.get(key);

        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            list.remove((Integer) key);
        }else if(list.size() == cap){
            int lru = list.remove(0);
            map.remove(lru);
        }
        list.add(key);
        map.put(key , value);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */