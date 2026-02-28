class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        int mod = 1_000_000_007;
        int length = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                length++;
            }
            res = ((res << length) + i) % mod;
        }
        return (int) res;
    }
}