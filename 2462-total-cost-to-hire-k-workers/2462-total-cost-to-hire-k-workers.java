class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int i = 0;
        int j = n - 1;
        for(int c = 0 ; c < candidates && i <= j ; c++){
            left.offer(costs[i++]);
        }
        for(int c = 0 ; c < candidates && i <= j ; c++){
            right.offer(costs[j--]);
        }
        long total = 0;
        while (k-- > 0) {
            if (right.isEmpty() || (!left.isEmpty() && left.peek() <= right.peek())) {
                total += left.poll();
                if (i <= j) {
                    left.offer(costs[i++]);
                }
            } else {
                total += right.poll();
                if (i <= j) {
                    right.offer(costs[j--]);
                }
            }
        }



        return total;
        
    }
}