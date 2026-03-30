class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String key = Arrays.toString(grid[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for (int j = 0; j < n; j++) {
            int[] col = new int[n];
            for (int i = 0; i < n; i++) {
                col[i] = grid[i][j];
            }
            String key = Arrays.toString(col);
            count += map.getOrDefault(key, 0);
        }

        return count;
    }
}