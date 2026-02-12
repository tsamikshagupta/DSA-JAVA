class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        DSU(int n){
            parent = new int[n + 1];
            rank = new int[n + 1];
            for(int i = 1 ; i <=n ; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }
        int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y){
            int rootx = find(x);
            int rooty = find(y);
            if(rootx == rooty){
                return false;
            }

            if(rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            }else if(rank[rootx] > rank[rooty]){
                parent[rooty] = rootx;
            }else{
                parent[rooty] = rootx;
                rank[rootx]++;
            }
            return true;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);
        for(int[] edge : edges){
            if(!dsu.union(edge[0], edge[1])){
                return edge;
            }
        }
        return new int[0];  
    }
}