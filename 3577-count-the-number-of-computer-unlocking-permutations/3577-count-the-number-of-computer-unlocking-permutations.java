class Solution {
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        long mod = 1_000_000_007;
        for (int i = 1; i < n; i++) {
            boolean ok = false;
            for (int j = 0; j < i; j++) {
                if (complexity[j] < complexity[i]) {
                    ok = true;
                    break;
                }
            }
            if (!ok) return 0;
        }

        long ans = 1;
        for (int k = 1; k <= n - 1; k++) {
            ans = (ans * k) % mod;
        }

        return (int) ans;  
    }
}