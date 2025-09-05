import java.util.*;
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        int needleLen = needle.length();
        int haystackLen = haystack.length();
        if(needleLen > haystackLen) return -1;
        for(int i=0;i<=haystackLen-needleLen;i++){
            if(haystack.substring(i,i+needleLen).equals(needle)){
                return i;
            }
        }
        return -1;
    }
   
}