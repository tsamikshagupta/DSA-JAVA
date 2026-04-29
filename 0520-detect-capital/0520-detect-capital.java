class Solution {
    public boolean detectCapitalUse(String word) {
        int upper = 0;
        for(char c : word.toCharArray()){
            if(Character.isUpperCase(c)){
                upper++;
            }
        }
        if(upper == word.length()) return true; 
        if(upper == 0) return true;
        if(upper == 1 && Character.isUpperCase(word.charAt(0))) return true;
        return false;
    }
}