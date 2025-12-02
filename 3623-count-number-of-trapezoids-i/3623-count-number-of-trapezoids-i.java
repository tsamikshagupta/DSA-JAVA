class Solution {
    static final long MOD = 1_000_000_007;
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] p : points) {
            map.put(p[1], map.getOrDefault(p[1], 0) + 1);
        }
        long sum = 0, sumSq = 0;
        for (int count : map.values()) {
            if (count >= 2) {
                long seg = (long) count * (count - 1) / 2;
                seg %= MOD;
                sum = (sum + seg) % MOD;
                sumSq = (sumSq + (seg * seg) % MOD) % MOD;
            }
        }
        long ans = (sum * sum % MOD - sumSq + MOD) % MOD;
        ans = ans * ((MOD + 1) / 2) % MOD; 
        return (int) ans;
    }
}