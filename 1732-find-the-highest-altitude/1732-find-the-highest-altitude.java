class Solution {
    public int largestAltitude(int[] gain) {
        int curr = 0;
        int max = 0;
        for(int g : gain){
            curr += g;
            max = Math.max(max , curr);
        }
        return max;
        
    }
}