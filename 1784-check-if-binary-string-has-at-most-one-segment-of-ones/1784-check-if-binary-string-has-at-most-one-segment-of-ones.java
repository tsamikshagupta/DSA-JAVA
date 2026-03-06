class Solution {
    public boolean checkOnesSegment(String s) {
       boolean iszero = false;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '0'){
                iszero = true;
            }else if(iszero){
                return false;
            }
        }
        return true;
        //return !s.contains("01");
    
        
    }
}