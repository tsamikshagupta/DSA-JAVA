class Solution {
    public int minimumDeletions(String s) {
        int count = 0;
        int del = 0;
        for(char c : s.toCharArray()){
            if(c == 'b'){
                count++;
            }else{
                del = Math.min(del + 1, count);
            }

        }
        return del; 
    }
}