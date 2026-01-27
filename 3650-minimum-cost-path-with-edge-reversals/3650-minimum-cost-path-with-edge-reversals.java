class Solution {
    static class Edge {
        int to;
        int w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }
    static class Node {
        int v;
        long d;
        Node(int v, long d) { this.v = v; this.d = d; }
    }
    public int minCost(int n, int[][] edges) {
        List<Edge>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(new Edge(v, w));        
            g[v].add(new Edge(u, 2 * w));    
        }

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.d));
        dist[0] = 0;
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.v;
            long d = cur.d;
            if (d != dist[u]) continue;
            if (u == n - 1) break;

            for (Edge ed : g[u]) {
                int v = ed.to;
                long nd = d + ed.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new Node(v, nd));
                }
            }
        }

        return dist[n - 1] >= INF ? -1 : (int) dist[n - 1];
    }
}
