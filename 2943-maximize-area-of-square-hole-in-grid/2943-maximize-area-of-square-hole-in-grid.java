class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = maxConsecutive(hBars);
        int maxV = maxConsecutive(vBars);
        int side = Math.min(maxH + 1, maxV + 1);
        return side * side;
        
    }
    private int maxConsecutive(int[] bars) {
        Arrays.sort(bars);
        int maxLen = 1;
        int currLen = 1;
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                currLen++;
            } else {
                currLen = 1;
            }
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}