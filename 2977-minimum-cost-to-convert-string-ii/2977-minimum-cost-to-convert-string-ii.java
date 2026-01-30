class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int n = source.length();
        int m = original.length;
        long INF = (long) 1e18;
        Map<String, Integer> id = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < m; i++) {
            if (!id.containsKey(original[i])) id.put(original[i], idx++);
            if (!id.containsKey(changed[i])) id.put(changed[i], idx++);
        }

        int V = idx;
        long[][] dist = new long[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (source.charAt(i) == target.charAt(i)) {
                dp[i] = dp[i + 1];
            }
            for (String s : id.keySet()) {
                int len = s.length();
                if (i + len > n) continue;

                String srcSub = source.substring(i, i + len);
                String tgtSub = target.substring(i, i + len);
                if (!id.containsKey(srcSub) || !id.containsKey(tgtSub)) continue;

                int u = id.get(srcSub);
                int v = id.get(tgtSub);

                if (dist[u][v] != INF) {
                    dp[i] = Math.min(dp[i], dist[u][v] + dp[i + len]);
                }
            }
        }

        return dp[0] >= INF ? -1 : dp[0];
    }
}
