class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        boolean[] sorted = new boolean[n]; 
        int deletions = 0;

        for (int col = 0; col < m; col++) {
            boolean bad = false;

            for (int i = 1; i < n; i++) {
                if (sorted[i]) continue; 
                char a = strs[i - 1].charAt(col);
                char b = strs[i].charAt(col);
                if (a > b) {
                    bad = true;
                    break;
                }
            }
            if (bad) {
                deletions++;
                continue;
            }
            for (int i = 1; i < n; i++) {
                if (sorted[i]) continue;
                char a = strs[i - 1].charAt(col);
                char b = strs[i].charAt(col);
                if (a < b) {
                    sorted[i] = true;
                }
            }
        }

        return deletions;
    }
}
