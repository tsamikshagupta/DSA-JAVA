class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;
        for (int n : nums) {
            int sum = 1 + n;
            int count = 2;
            boolean valid = true;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    int j = n / i;
                    if (i == j) {
                        count++;
                        sum += i;
                    } else {
                        count += 2;
                        sum += i + j;
                    }

                    if (count > 4) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid && count == 4) {
                totalSum += sum;
            }
        }

        return totalSum;
        
    }
}