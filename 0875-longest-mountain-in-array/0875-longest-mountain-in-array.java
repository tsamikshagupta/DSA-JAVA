class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int maxLength = 0;
        int i = 1;
        while (i < n - 1) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i;
                int right = i;
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }
                int length = right - left + 1;
                maxLength = Math.max(maxLength, length);
                i = right;
            } else {
                i++;
            }
        }
        return maxLength >= 3 ? maxLength : 0;
    }
        
    }
