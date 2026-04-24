class Solution {
    public int findMinArrowShots(int[][] a) {
        Arrays.sort(a, (x, y) -> Integer.compare(x[1], y[1]));
        int arrows = 1;
        int end = a[0][1];
        for (int i = 1; i < a.length; i++) {
            if (a[i][0] > end) {
                arrows++;
                end = a[i][1];
            }
        }
        return arrows;
    }
}