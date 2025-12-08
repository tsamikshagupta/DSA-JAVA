class Solution {
    public int countTriples(int n) {
        int count = 0 ;
        for(int a = 1; a<=n ; a++){
            int a2 = a * a;
        
        for(int b = 1; b<=n ; b++){
            int b2 = b * b;
            int sum = a2 + b2;
            int c = (int)Math.sqrt(sum);
            if(c * c==sum && c<=n){
                count++;
            }

        }

        }
        return count;
        
    }
}