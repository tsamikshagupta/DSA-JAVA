class Solution {
    public char findKthBit(int n, int k) {
        boolean invert = false;
        while (n > 1) {
            int len = (1 << n) - 1;
            int mid = (len + 1) / 2;
            if (k == mid) {
                return invert ? '0' : '1';
            }
            if (k > mid) {
                k = len - k + 1;
                invert = !invert;
            }
            n--;
        }
        
        return invert ? '1' : '0';
    }
}