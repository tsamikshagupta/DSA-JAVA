class Solution {
    public long maxSubarraySum(int[] nums, int k) {long[] best = new long[k];
        Arrays.fill(best, Long.MAX_VALUE);
        long ans = Long.MIN_VALUE;
        long prefix = 0;
        best[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int mod = (i + 1) % k;
            if (best[mod] != Long.MAX_VALUE) {
                ans = Math.max(ans, prefix - best[mod]);
            }
            best[mod] = Math.min(best[mod], prefix);
        }
        return ans; 
    }
}