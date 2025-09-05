import java.util.*;
class Solution {
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = getSumOfSquares(slow);
            fast = getSumOfSquares(getSumOfSquares(fast));
            if(slow==1|| fast==1){
                return true;
            }
        }while(slow!=fast);
        return false;
    }
    private static int getSumOfSquares(int n){
        int sum = 0;
        while(n>0){
            int digit = n%10;
            sum+= digit*digit;
            n/=10;
        }
        return sum;
    }
    
}