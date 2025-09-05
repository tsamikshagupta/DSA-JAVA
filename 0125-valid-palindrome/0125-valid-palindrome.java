import java.util.*;

class Solution {
    public boolean isPalindrome(String str) {
        String s = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return checkPalindrome(s, 0, s.length() - 1);
    }

    private boolean checkPalindrome(String str, int left, int right) {
        if (left >= right) return true;
        if (str.charAt(left) != str.charAt(right)) return false;
        return checkPalindrome(str, left + 1, right - 1);
    }

   
}