class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
         long l=1,r=(long)1e16;
        while(l<r) {
            long m=(l+r)/2,s=0;
            for(int t:workerTimes) {
                long x=(long)((Math.sqrt(1+8.0*m/t)-1)/2);
                s+=x;
            }
            if(s>=mountainHeight) r=m;
            else l=m+1;
        }
        return l;
    }
}