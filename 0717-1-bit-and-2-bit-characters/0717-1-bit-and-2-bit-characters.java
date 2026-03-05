class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int count = 0;
        for(int i = bits.length - 2 ; i>=0 && bits[i] == 1; i--){
            count++;
        }
        return count % 2== 0;
        
    }
}