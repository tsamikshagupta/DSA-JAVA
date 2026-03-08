class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(String s : nums){
            set.add(Integer.parseInt(s , 2));
        }
        for(int i = 0 ; i < (1 << n); i++){
            if(!set.contains(i)){
                String s = Integer.toBinaryString(i);
                while(s.length() < n) s = "0" + s;
                return s;
            }
        }
        return "";

        
    }
}