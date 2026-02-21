class Solution {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        int mask = 665772;
        for(int i = left ; i <= right; i++){
            count += (mask >> Integer.bitCount(i)) & 1;
        }
        return count;
        
    }
}