class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long MOD = 1_000_000_007L;
        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];   

        dp[0] = 1;
        pref[0] = 1;

        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        int left = 0;  

        for (int i = 0; i < n; i++) {

            while (!maxD.isEmpty() && maxD.peekLast() < nums[i])
                maxD.pollLast();
            maxD.addLast(nums[i]);

            while (!minD.isEmpty() && minD.peekLast() > nums[i])
                minD.pollLast();
            minD.addLast(nums[i]);

            while (!maxD.isEmpty() && !minD.isEmpty() && 
                   (maxD.peekFirst() - minD.peekFirst() > k)) {
                if (maxD.peekFirst() == nums[left]) maxD.pollFirst();
                if (minD.peekFirst() == nums[left]) minD.pollFirst();
                left++;
            }

            long ways = pref[i] - (left == 0 ? 0 : pref[left - 1]);
            ways = (ways % MOD + MOD) % MOD;

            dp[i + 1] = ways;
            pref[i + 1] = (pref[i] + ways) % MOD;
        }
        return (int) dp[n]; 
    }
}