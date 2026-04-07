class Solution {
    public int minEatingSpeed(int[] piles, int h) {
          int max=Arrays.stream(piles).max().getAsInt();
        int left=1,right=max;
        while(left<right){
            int k=left+(right-left)/2;
            long hours=0;
            for(int pile:piles){
                hours+=(pile + k-1)/k;
            }
            if(hours<=h){
                right=k;
            }
            else{
                left=k+1;
            }
        }
        return left;
        
    }
}