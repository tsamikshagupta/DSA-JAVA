class Solution {
    TreeMap<Integer, Integer> l = new TreeMap<>();
    TreeMap<Integer, Integer> r = new TreeMap<>();
    long sl = 0, sr = 0;
    int nl = 0, nr = 0;
    void add(int v) {
        if (l.isEmpty() || v <= l.lastKey()) {
            l.put(v, l.getOrDefault(v, 0) + 1);
            sl += v;
            nl++;
        } else {
            r.put(v, r.getOrDefault(v, 0) + 1);
            sr += v;
            nr++;
        }
        balance();
    }
    void remove(int v) {
        if (l.containsKey(v)) {
            del(l, v);
            sl -= v;
            nl--;
        } else {
            del(r, v);
            sr -= v;
            nr--;
        }
        balance();
    }

    void del(TreeMap<Integer, Integer> m, int v) {
        if (m.get(v) == 1) m.remove(v);
        else m.put(v, m.get(v) - 1);
    }
    void balance() {
        while (nl > nr + 1) {
            int v = l.lastKey();
            del(l, v);
            sl -= v;
            nl--;

            r.put(v, r.getOrDefault(v, 0) + 1);
            sr += v;
            nr++;
        }
        while (nl < nr) {
            int v = r.firstKey();
            del(r, v);
            sr -= v;
            nr--;
            l.put(v, l.getOrDefault(v, 0) + 1);
            sl += v;
            nl++;
        }
    }
    long cost() {
        int m = l.lastKey();
        return (long) m * nl - sl + sr - (long) m * nr;
    }
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] c = new long[n - x + 1];
        for (int i = 0; i < n; i++) {
            add(nums[i]);
            if (i >= x) remove(nums[i - x]);
            if (i >= x - 1) {
                c[i - x + 1] = cost();
            }
        }
        long inf = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], inf);
            dp[i][0] = (i == 0) ? 0 : inf;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];
                if (i >= x && dp[j - 1][i - x] != inf) {
                    dp[j][i] = Math.min(
                        dp[j][i],
                        dp[j - 1][i - x] + c[i - x]
                    );
                }
            }
        }
        return dp[k][n];
    }
}