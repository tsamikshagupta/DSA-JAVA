class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int tapples = 0;
        for(int a:apple) tapples += a;
        Arrays.sort(capacity);
        int used = 0;
        int csum = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            csum += capacity[i];
            used++;
            if (csum >= tapples) return used;
        }
        return used;
    }
}