class Solution {
    public int minOperations(String s) {
        int n = s.length();
        StringBuilder p1 = new StringBuilder();
        StringBuilder p2 = new StringBuilder();
        for(int i = 0; i < n ; i++){
            if(i % 2 == 0){
                p1.append('0');
                p2.append('1');
            }else{
                p1.append('1');
                p2.append('0');

            }
        }
        int c1 = 0 , c2 = 0;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) != p1.charAt(i)) c1++;
            if(s.charAt(i) != p2.charAt(i)) c2++;
        }
        return Math.min(c1 , c2);
        
    }
}