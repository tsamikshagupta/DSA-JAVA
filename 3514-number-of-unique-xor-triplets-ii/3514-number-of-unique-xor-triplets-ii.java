class Solution {
    public int uniqueXorTriplets(int[] nums) {
        boolean[] pair = new boolean[2048];
        boolean[] ans = new boolean[2048];
        for (int a : nums) {
            for (int b : nums) {
                pair[a ^ b] = true;
            }
        }
        for (int i = 0; i < 2048; i++) {
            if (!pair[i]) {
                continue;
            }
            for (int x : nums) {
                ans[i ^ x] = true;
            }
        }
        int count = 0;
        for (boolean present : ans) {
            if (present) {
                count++;
            }
        }
        return count;
    }
}