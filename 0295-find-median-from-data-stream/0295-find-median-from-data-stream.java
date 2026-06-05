class MedianFinder {
    private PriorityQueue<Integer> small; // max heap
    private PriorityQueue<Integer> large; // min heap
    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>();
    }
    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());
        if (large.size() > small.size() + 1) {
            small.offer(large.poll());
        }
    }
    public double findMedian() {
        if (small.size() == large.size()) {
            return ((double) small.peek() + large.peek()) / 2.0;
        }
        return large.peek();
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */