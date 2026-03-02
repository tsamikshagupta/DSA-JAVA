class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        List<Integer> list = new ArrayList<>();
        for (int[] row : grid) {
            int count = 0;
            for (int j = n - 1; j >= 0 && row[j] == 0; j--) {
                count++;
            }
            list.add(count);
        }
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int required = n - i - 1;
            int j = i;
            while (j < n && list.get(j) < required) {
                j++;
            }
            if (j == n) return -1;
            while (j > i) {
                Collections.swap(list, j, j - 1);
                swaps++;
                j--;
            }
        }

        return swaps;
    }
}