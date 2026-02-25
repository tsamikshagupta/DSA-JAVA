class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++) {
            pairs[i][0] = arr[i];
            pairs[i][1] = Integer.bitCount(arr[i]);
        }
        Arrays.sort(pairs, (a, b) -> {
            if(a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        for(int i = 0; i < n; i++)
            arr[i] = pairs[i][0];

        return arr;
    }
}