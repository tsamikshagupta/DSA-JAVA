class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int dup = -1;
        int miss = -1;
        for(int num : nums){
            if(!set.add(num)){
                dup = num;
            }
        }
        for(int i = 1;i<=nums.length;i++){
            if(!set.contains(i)){
                miss = i;
                break;
            }
        }
        
        return new int[]{dup, miss};

        
    }
}