class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m * k > n)
            return -1;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for(int x : bloomDay){
            l = Math.min(l, x);
            r = Math.max(r, x);
        }
        int ans = -1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int count = 0;
            int bouquets = 0;
            for(int x : bloomDay){
                if(x <= mid){
                    count++;
                    if(count == k){
                        bouquets++;
                        count = 0;
                    }
                }
                else{
                    count = 0;
                }
            }
            if(bouquets >= m){
                ans = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return ans;
    }
}