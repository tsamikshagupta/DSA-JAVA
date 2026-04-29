class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int x : target) {
            pq.add(x);
            sum += x;
        }
        while (true) {
            int max = pq.poll();
            long rest = sum - max;
            if (max == 1 || rest == 1) return true;
            if (rest == 0 || max < rest) return false;
            int prev = (int)(max % rest);
            if (prev == 0) return false;
            pq.add(prev);
            sum = rest + prev;
        }
    }
}