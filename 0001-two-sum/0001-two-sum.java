class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> nm_to_index = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int complement = target - nums[i];
            if(nm_to_index.containsKey(complement)){
                return new int[]{nm_to_index.get(complement), i};
            }
            nm_to_index.put(nums[i], i);
        }
        return new int[]{};

       
    }

}