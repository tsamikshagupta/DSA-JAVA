class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int left = 0 , right = 0;
        int maxLen = 0, maxFreq = 0;
        while(right < n){
            int i = s.charAt(right) - 'A';
            freq[i]++;
            maxFreq = Math.max(maxFreq ,freq[i]);
            int wlen = right - left + 1;
            if(wlen - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
               // maxLen = Math.max(maxLen , right - left + 1);
            }
            maxLen = Math.max(maxLen , right - left + 1);
            right++;
        }
        return maxLen;
        
    }
}