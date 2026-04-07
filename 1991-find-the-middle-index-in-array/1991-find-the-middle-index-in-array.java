class Solution {
    public int findMiddleIndex(int[] nums) {
         int total = 0;
        for (int value : nums) {
            total += value;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int right = total - left - current;
            if (left == right) {
                return i;
            }
            left += current;
        }
        return -1;
    }
}