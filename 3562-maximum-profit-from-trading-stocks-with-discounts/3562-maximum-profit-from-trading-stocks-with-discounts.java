class Solution {
    static final int NEG = -1_000_000_000;

    int n, B;
    int[] present, future;
    List<Integer>[] tree;
    int[][] dp0, dpF, dpD;

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.n = n;
        this.present = present;
        this.future = future;
        this.B = budget;

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] e : hierarchy) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            tree[u].add(v);
        }

        dp0 = new int[n][B + 1];
        dpF = new int[n][B + 1];
        dpD = new int[n][B + 1];

        dfs(0);

        int ans = 0;
        for (int b = 0; b <= B; b++) {
            ans = Math.max(ans, Math.max(dp0[0][b], dpF[0][b])); 
        }
        return ans;
    }

    private void dfs(int u) {
        Arrays.fill(dp0[u], NEG);
        Arrays.fill(dpF[u], NEG);
        Arrays.fill(dpD[u], NEG);

        dp0[u][0] = 0;

        int fullCost = present[u];
        int fullProfit = future[u] - fullCost;
        if (fullCost <= B) dpF[u][fullCost] = fullProfit; 

        int discCost = fullCost / 2;
        int discProfit = future[u] - discCost;
        if (discCost <= B) dpD[u][discCost] = discProfit;

        for (int v : tree[u]) {
            dfs(v);

            int[] new0 = new int[B + 1];
            int[] newF = new int[B + 1];
            int[] newD = new int[B + 1];
            Arrays.fill(new0, NEG);
            Arrays.fill(newF, NEG);
            Arrays.fill(newD, NEG);

            int[] childBestNoDisc = new int[B + 1];
            int[] childBestWithDisc = new int[B + 1];
            for (int j = 0; j <= B; j++) {
                childBestNoDisc[j] = Math.max(dp0[v][j], dpF[v][j]);
                childBestWithDisc[j] = Math.max(dp0[v][j], dpD[v][j]);
            }

            for (int i = 0; i <= B; i++) {
                if (dp0[u][i] == NEG) continue;
                for (int j = 0; i + j <= B; j++) {
                    if (childBestNoDisc[j] == NEG) continue;
                    new0[i + j] = Math.max(new0[i + j], dp0[u][i] + childBestNoDisc[j]);
                }
            }

            for (int i = 0; i <= B; i++) {
                if (dpF[u][i] == NEG) continue;
                for (int j = 0; i + j <= B; j++) {
                    if (childBestWithDisc[j] == NEG) continue;
                    newF[i + j] = Math.max(newF[i + j], dpF[u][i] + childBestWithDisc[j]);
                }
            }

            for (int i = 0; i <= B; i++) {
                if (dpD[u][i] == NEG) continue;
                for (int j = 0; i + j <= B; j++) {
                    if (childBestWithDisc[j] == NEG) continue;
                    newD[i + j] = Math.max(newD[i + j], dpD[u][i] + childBestWithDisc[j]);
                }
            }

            dp0[u] = new0;
            dpF[u] = newF;
            dpD[u] = newD;
        }
    }
}
