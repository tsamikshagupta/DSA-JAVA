class SmallestInfiniteSet {
    private int current;
    private PriorityQueue<Integer> minHeap;
    private HashSet<Integer> set;
    public SmallestInfiniteSet() {
        current = 1;
        minHeap = new PriorityQueue<>();
        set = new HashSet<>();
    }
    
    public int popSmallest() {
        if (!minHeap.isEmpty()) {
            int val = minHeap.poll();
            set.remove(val);
            return val;
        }
        return current++;
        
    }
    
    public void addBack(int num) {
        if (num < current && !set.contains(num)) {
            minHeap.offer(num);
            set.add(num);
        }   
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */