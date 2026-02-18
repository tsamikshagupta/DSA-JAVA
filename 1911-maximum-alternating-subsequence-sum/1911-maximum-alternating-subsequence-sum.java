class Solution {
    public long maxAlternatingSum(int[] nums) {
        long add = 0;      
        long subtract = 0; 
        for (int num : nums) {
            long maxadd = Math.max(add, subtract + num);
            long maxsub = Math.max(subtract, add - num);
            add = maxadd;
            subtract = maxsub;
        }
        return add;
    }
}
