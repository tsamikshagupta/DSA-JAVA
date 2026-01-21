class Solution {

    private void dfs(int node, int[][] isConnected, boolean[] visited) {
        visited[node] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[node][j] == 1 && !visited[j]) {
                dfs(j, isConnected, visited);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                provinces++;
            }
        }

        return provinces;
    }
}
