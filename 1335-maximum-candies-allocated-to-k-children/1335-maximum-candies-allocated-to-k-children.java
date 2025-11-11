class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left = 1;
        int right = 0;
        for (int c : candies) {
            right = Math.max(right, c);
        }

        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(candies, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private boolean canDistribute(int[] candies, long k, int x) {
        if (x == 0) return true; 
        long count = 0;
        for (int c : candies) {
            count += c / x;
            if (count >= k) return true; 
        }
        return false;
    }
}