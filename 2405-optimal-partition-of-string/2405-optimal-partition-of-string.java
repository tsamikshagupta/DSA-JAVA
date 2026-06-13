class Solution {
    public int partitionString(String s) {
        boolean[] seen = new boolean[26];
        int count = 1;
        for(int i = 0; i < s.length(); i++){
            int ch = s.charAt(i) - 'a';
            if(seen[ch]){
                count++;
                seen = new boolean[26];
            }
            seen[ch] = true;
        }
        return count;
        
    }
}