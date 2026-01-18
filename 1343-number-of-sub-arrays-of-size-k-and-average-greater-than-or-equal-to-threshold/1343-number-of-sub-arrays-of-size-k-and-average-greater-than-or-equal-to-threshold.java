class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int sum = 0;
        for(int i = 0 ; i < k ; i++){
            sum += arr[i];
        }
        int count = 0;
        int target = threshold * k;
        if(sum >= target) count++;
        for(int i = k ; i < n ;i++){
            sum = sum - arr[i-k] + arr[i];
            if(sum >= target){
                count++;
                
            }
        }
        return count;
        
    }
}