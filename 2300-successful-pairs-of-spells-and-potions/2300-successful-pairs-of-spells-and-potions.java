class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            long min = (success + spell - 1) / spell; 
    
            int left = 0, right = m - 1;
            int index = m; 
            while (left <= right) {
                int mid = left + (right - left) / 2;
                
                if (potions[mid] >= min) {
                    index = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            
            result[i] = m - index;
        }
        
        return result;
    }
}