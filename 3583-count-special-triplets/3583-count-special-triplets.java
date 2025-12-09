class Solution {
    public int specialTriplets(int[] nums) {
        final long MOD = 1_000_000_007L;
        int n = nums.length;
        long[] right = new long[200001];
        for (int x : nums) right[x]++;

        long[] left = new long[200001];
        long ans = 0;

        for (int j = 0; j < n; j++) {
            int val = nums[j];
            right[val]--; 

            int target = val * 2;
            if (target <= 200000) {
                long cntLeft = left[target];
                long cntRight = right[target];
                ans = (ans + (cntLeft * cntRight) % MOD) % MOD;
            }

            left[val]++; 
        }

        return (int) ans;  
    }
}