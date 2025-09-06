class Solution {
    public int arrangeCoins(int n) {
        int row = 0;
        for(int i=1;i<=n;i++){
            n = n-i;
            row++;
        }
        return row;
    }
}