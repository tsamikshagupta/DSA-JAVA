class Solution {
    public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (a.length == 0 || b.length == 0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x, y) -> x[0] - y[0]
        );
        for (int i = 0; i < Math.min(a.length, k); i++) {
            pq.offer(new int[]{a[i] + b[0], i, 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[1], j = cur[2];
            res.add(Arrays.asList(a[i], b[j]));
            if (j + 1 < b.length) {
                pq.offer(new int[]{a[i] + b[j + 1], i, j + 1});
            }
        }

        return res;
    }
}