class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0 , right = 0 , max = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            if(!seen.contains(c)){
                seen.add(c);
                max = Math.max(max , right - left + 1);
                right++;
            }else{
                seen.remove(s.charAt(left));
                left++;
            }
            
            
        }
        return max;
    }
    
}