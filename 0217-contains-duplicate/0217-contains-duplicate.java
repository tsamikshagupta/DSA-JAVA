import java.util.*;
class Solution {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for(int num:nums){
            if(!seen.add(num)){
                return true;
            }
        }
        return false;   
    }
    
}