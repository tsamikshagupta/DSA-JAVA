class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxlen = 0;
        int[] even = new int[100001];
        int[] odd = new int[100001];
        int time = 1;
        for (int i = 0; i < n; i++) {
            int evenc = 0;
            int oddc = 0;
            time++; 
            for (int j = i; j < n; j++) {
                int val = nums[j];

                if (val % 2 == 0) {
                    if (even[val] != time) {
                        even[val] = time;
                        evenc++;
                    }
                } else {
                    if (odd[val] != time) {
                        odd[val] = time;
                        oddc++;
                    }
                }
                if (evenc == oddc) {
                    maxlen = Math.max(maxlen, j - i + 1);
                }
            }
        }
        return maxlen;
    }
}
