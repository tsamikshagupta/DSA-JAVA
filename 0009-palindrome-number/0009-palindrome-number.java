import java.util.*;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String str = String.valueOf(x);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) { 
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        System.out.println("x = ");
        int inp = sc.nextInt();
        boolean result = sol.isPalindrome(inp);
        System.out.println(result);
    }
}