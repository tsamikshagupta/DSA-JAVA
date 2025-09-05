class Solution {
    public int lengthOfLongestSubstring(String s) {
        java.util.HashSet<Character> seen = new java.util.HashSet<>();
        int left=0, right=0, maxlength=0;

        while(right<s.length()){
            char currentchar = s.charAt(right);

            if(!seen.contains(currentchar)){
                seen.add(currentchar);
                maxlength = Math.max(maxlength, right-left+1);
                right++;
            }
            else{
                seen.remove(s.charAt(left));
                left++;
            }
        }
        return maxlength;
    }
    
}