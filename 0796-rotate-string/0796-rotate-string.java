class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        String merged = s + s;
        return merged.contains(goal);
        
    }
}