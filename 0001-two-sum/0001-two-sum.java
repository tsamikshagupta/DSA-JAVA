class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            int current = nums[i];
            int nextEle = target - current;
        
        if(map.containsKey(nextEle)){
            return new int[] {map.get(nextEle), i};
        }
        map.put(current,i);
        
    }
    return new int[] {-1,-1};
    }

}