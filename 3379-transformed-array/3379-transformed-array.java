class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int move = nums[i];
            if (move == 0) {
                res[i] = 0;
            } else {
                int j = i + move;
                j %= n;
                if (j < 0) j += n;
                res[i] = nums[j];
            }
        }
        return res;
    }
}
