class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int option1 = robLinear(nums, 0, n - 2);
        int option2 = robLinear(nums, 1, n - 1);
        return Math.max(option1, option2);
    }
    private int robLinear(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int pick = prev2 + nums[i];
            int skip = prev1;
            int curr = Math.max(pick, skip);

            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}