class Solution {
    public int minimumOperations(int[] nums) {
         int ops = 0;
        for (int num : nums) {
            int rem = num % 3;
            if (rem == 1 || rem == 2) {
                ops += 1;   
            }
        }
        return ops;
        
    }
}