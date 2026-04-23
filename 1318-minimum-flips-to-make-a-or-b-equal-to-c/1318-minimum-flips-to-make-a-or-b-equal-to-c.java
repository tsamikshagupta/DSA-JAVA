class Solution {
    public int minFlips(int a, int b, int c) {
        int f = 0;
        for(int i = 0 ; i < 32 ; i++){
            int bA = (a >> i) & 1;
            int bB = (b >> i) & 1;
            int bC = (c >> i) & 1;
            if(bC == 1){
                if(bA == 0 && bB == 0){
                    f += 1;
                }
            }else{
                if(bA == 1 && bB == 1){
                    f += 2;

                }else if(bA == 1 || bB == 1){
                    f += 1;
                }
            }
        }
        return f;
        
    }
}