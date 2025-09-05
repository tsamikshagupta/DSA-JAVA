import java.util.*;
class Solution {
    public static int myAtoi(String s) {
        if(s==null || s.length()==0) return 0;
        int index = 0;
        int sign = 1;
        long result = 0;
        while(index<s.length() && s.charAt(index)==' '){
            index++;
        }
        if(index<s.length() && (s.charAt(index) == '+' || s.charAt(index)== '-')){
            sign = s.charAt(index)=='+' ? 1:-1;
            index++;
        }
        while(index<s.length() && Character.isDigit(s.charAt(index))){
            result = result * 10 + (s.charAt(index) - '0');

            if(result * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(result * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            index++;
        }
        return (int)(result * sign);
    }
}