class Solution {
    public int countCollisions(String directions) {
        char[] arr = directions.toCharArray();
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left < n && arr[left] == 'L') {
            left++;
        }
        while (right >= 0 && arr[right] == 'R') {
            right--;
        }
        int collisions = 0;
        for (int i = left; i <= right; i++) {
            if (arr[i] == 'R' || arr[i] == 'L') {
                collisions++;
            }
        }
        return collisions;  
    }
}