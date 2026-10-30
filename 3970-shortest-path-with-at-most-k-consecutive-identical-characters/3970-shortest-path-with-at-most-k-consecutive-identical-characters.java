class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        int[][] dist = new int[n][k + 1];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long cost = curr[0];
            int node = (int) curr[1];
            int count = (int) curr[2];
            if (cost > dist[node][count]) {
                continue;
            }
            if (node == n - 1) {
                return (int) cost;
            }

            for (int[] next : graph[node]) {
                int neighbor = next[0];
                int weight = next[1];
                int nextCount = labels.charAt(node) == labels.charAt(neighbor)? count + 1 : 1;
                if (nextCount > k) {
                    continue;
                }

                long newCost = cost + weight;
                if (newCost < dist[neighbor][nextCount]) {
                    dist[neighbor][nextCount] = (int) newCost;
                    pq.offer(new long[]{newCost, neighbor, nextCount});
                }
            }
        }

        return -1;
    }
}