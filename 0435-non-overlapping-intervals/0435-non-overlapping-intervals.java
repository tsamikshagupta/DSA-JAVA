class Solution {
    public int eraseOverlapIntervals(int[][] a) {
        Arrays.sort(a, (x, y) -> x[1] - y[1]);
        int cnt = 0;
        int end = a[0][1];
        for (int i = 1; i < a.length; i++) {
            if (a[i][0] < end) {
                cnt++; 
            } else {
                end = a[i][1]; 
            }
        } 
        return cnt;
    }
}