class Solution {
    public int findKthLargest(int[] nums, int k) {
       PriorityQueue<Integer> minheap = new PriorityQueue<>();
       for(int n : nums){
        minheap.add(n);
        if(minheap.size() > k){
            minheap.poll();
        }
       }
       return minheap.peek();
    }
}