class Solution {

    static class Pair {
        long sum;
        int left, right, start;
        Pair(long s, int l, int r, int st) {
            sum = s;
            left = l;
            right = r;
            start = st;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        long[] val = new long[n];
        int[] prev = new int[n];
        int[] next = new int[n];
        int[] start = new int[n];
        boolean[] alive = new boolean[n];

        for (int i = 0; i < n; i++) {
            val[i] = nums[i];
            prev[i] = i - 1;
            next[i] = i == n - 1 ? -1 : i + 1;
            start[i] = i;
            alive[i] = true;
        }

        long inv = 0;
        for (int i = 0; i < n - 1; i++) {
            if (val[i] > val[i + 1]) inv++;
        }
        if (inv == 0) return 0;

        java.util.PriorityQueue<Pair> pq =
            new java.util.PriorityQueue<>((a, b) ->
                a.sum != b.sum ? Long.compare(a.sum, b.sum)
                               : Integer.compare(a.start, b.start));

        for (int i = 0; i < n - 1; i++) {
            pq.offer(new Pair(val[i] + val[i + 1], i, i + 1, start[i]));
        }

        int ops = 0;

        while (inv > 0) {
            Pair cur = pq.poll();
            int a = cur.left;
            int b = cur.right;

            if (!alive[a] || !alive[b]) continue;
            if (next[a] != b) continue;
            long s = val[a] + val[b];
            if (cur.sum != s) continue;

            int p = prev[a];
            int nn = next[b];

            if (p != -1 && val[p] > val[a]) inv--;
            if (val[a] > val[b]) inv--;
            if (nn != -1 && val[b] > val[nn]) inv--;

            val[a] = s;
            alive[b] = false;
            next[a] = nn;
            if (nn != -1) prev[nn] = a;

            if (p != -1 && val[p] > val[a]) inv++;
            if (nn != -1 && val[a] > val[nn]) inv++;

            ops++;

            if (p != -1 && alive[p]) {
                pq.offer(new Pair(val[p] + val[a], p, a, start[p]));
            }
            if (nn != -1 && alive[nn]) {
                pq.offer(new Pair(val[a] + val[nn], a, nn, start[a]));
            }
        }

        return ops;
    }
}
