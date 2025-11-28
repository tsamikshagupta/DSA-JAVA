class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        int[] components = new int[1]; 
        dfs(0, graph, values, k, visited, components);
        return components[0];   
    }
    private long dfs(int node, List<List<Integer>> graph, int[] values, int k,
                     boolean[] visited, int[] components) {

        visited[node] = true;
        long sum = values[node];
        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                sum += dfs(nei, graph, values, k, visited, components);
            }
        }
        if (sum % k == 0) {
            components[0]++;        
            return 0;               
        }
        return sum;
    }
}