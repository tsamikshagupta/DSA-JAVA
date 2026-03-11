class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0) return 1;
        int temp = n;
        int m = 0;
        while(temp > 0){
            m = (m << 1) | 1;
            temp >>= 1;
        }
        return n ^ m;
        
        
    }
}