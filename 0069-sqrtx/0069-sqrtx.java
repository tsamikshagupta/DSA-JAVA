class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1) return x;
        long low = 1, high = x;
        int result = 0;
        while(low <=high){
            long mid = low + (high - low) / 2;
            long square = mid * mid;
            if(square ==x){
                return (int)mid;
            }else if(square < x){
                result = (int)mid;
                low = mid + 1;

            }else{
                high = mid - 1;

            }
        }
        return result;
        
    }
}