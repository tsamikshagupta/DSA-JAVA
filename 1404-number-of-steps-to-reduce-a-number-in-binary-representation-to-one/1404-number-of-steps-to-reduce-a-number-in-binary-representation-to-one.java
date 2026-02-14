class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0';
            if (bit + carry == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps += 1;
            }
        }
        return steps + carry;
    }
}

       /* Long n = Long.parseLong(s , 2);
        int count = 0;
        while(n != 1){
            if( n % 2 == 0){
                n/=2;
            }else{
                n+=1;
            }
            count++;
        }
        return count;
        
    }
}*/