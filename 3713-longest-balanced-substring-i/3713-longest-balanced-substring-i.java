class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxlen = 0;
        for(int i = 0 ; i < n ; i++){
            int[] freq = new int[26];
            int distinct = 0;
            int maxfreq = 0;
            for(int j = i ;j < n ; j++){
                int index = s.charAt(j) - 'a';
                if(freq[index] == 0){
                    distinct++;
                }
                freq[index]++;
                maxfreq = Math.max(maxfreq, freq[index]);
                int length = j - i + 1;

                if(length == distinct * maxfreq){
                    maxlen = Math.max(maxlen , length);
                }
            }
        }
        return maxlen;
        
    }
}