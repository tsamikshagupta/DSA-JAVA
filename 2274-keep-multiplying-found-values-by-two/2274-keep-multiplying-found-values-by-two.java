class Solution {
    public int findFinalValue(int[] nums, int original) {
        int val = original;
        boolean found = true;
        while (found) {
            found = false;
            for (int num : nums) {
                if (num == val) {
                    val *= 2;
                    found = true;
                    break;
                }
            }
        }
        return val;
    }
}
