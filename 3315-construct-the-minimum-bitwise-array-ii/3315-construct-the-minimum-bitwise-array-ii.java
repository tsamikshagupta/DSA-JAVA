import java.util.*;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int p = nums.get(i);

            if (p == 2) {
                ans[i] = -1;
                continue;
            }
            int trailingOnes = 0;
            int t = p;
            while ((t & 1) == 1) {
                trailingOnes++;
                t >>= 1;
            }

            long best = Long.MAX_VALUE;
            for (int L = 1; L <= trailingOnes; L++) {
                long prefix = (long) p >> L;
                long cand = (prefix << L) + ((1L << (L - 1)) - 1);
                if ( (cand | (cand + 1)) == p ) {
                    if (cand < best) best = cand;
                }
            }

            ans[i] = (best == Long.MAX_VALUE) ? -1 : (int) best;
        }

        return ans;
    }
}
