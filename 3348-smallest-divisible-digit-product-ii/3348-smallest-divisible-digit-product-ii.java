class Solution {
    int[][] factor = {
        {0,0,0,0},
        {0,0,0,0},
        {1,0,0,0},
        {0,1,0,0},
        {2,0,0,0},
        {0,0,1,0},
        {1,1,0,0},
        {0,0,0,1},
        {3,0,0,0},
        {0,2,0,0}
    };
    public String smallestNumber(String num, long t) {
        int[] need = new int[4];
        int[] primes = {2, 3, 5, 7};
        for (int i = 0; i < 4; i++) {
            while (t % primes[i] == 0) {
                need[i]++;
                t /= primes[i];
            }
        }
        if (t != 1) return "-1";
        int n = num.length();
        int[][] prefix = new int[n + 1][4];
        int firstZero = -1;
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            if (digit == 0 && firstZero == -1)
                firstZero = i;
            for (int j = 0; j < 4; j++)
                prefix[i + 1][j] = prefix[i][j] + factor[digit][j];
        }

        if (firstZero == -1 && valid(prefix[n], need))
            return num;
        for (int i = n - 1; i >= 0; i--) {
            if (firstZero != -1 && firstZero < i)
                continue;
            int current = num.charAt(i) - '0';
            for (int digit = Math.max(1, current + 1); digit <= 9; digit++) {
                int[] left = new int[4];
                for (int j = 0; j < 4; j++) {
                    left[j] = Math.max(0, need[j] - prefix[i][j] - factor[digit][j]);
                }
                String rest = makeSmallest(left, n - i - 1);
                if (rest != null)
                    return num.substring(0, i) + digit + rest;
            }
        }
        for (int len = n + 1; len <= n + 50; len++) {
            String ans = makeSmallest(need, len);
            if (ans != null)
                return ans;
        }
        return "-1";
    }

    boolean valid(int[] have, int[] need) {
        for (int i = 0; i < 4; i++) {
            if (have[i] < need[i])
                return false;
        }
        return true;
    }

    String makeSmallest(int[] need, int len) {
        int twos = need[0];
        int threes = need[1];
        int fives = need[2];
        int sevens = need[3];
        String best = null;
        for (int sixes = 0; sixes <= Math.min(twos, threes); sixes++) {
            int a = twos - sixes;
            int b = threes - sixes;
            StringBuilder s = new StringBuilder();
            if (a % 3 == 1)
                s.append('2');
            else if (a % 3 == 2)
                s.append('4');

            if (b % 2 == 1)
                s.append('3');

            for (int i = 0; i < fives; i++)
                s.append('5');

            for (int i = 0; i < sixes; i++)
                s.append('6');

            for (int i = 0; i < sevens; i++)
                s.append('7');

            for (int i = 0; i < a / 3; i++)
                s.append('8');

            for (int i = 0; i < b / 2; i++)
                s.append('9');

            char[] digits = s.toString().toCharArray();
            java.util.Arrays.sort(digits);
            String cur = new String(digits);
            if (best == null ||
                cur.length() < best.length() ||
                (cur.length() == best.length() && cur.compareTo(best) < 0)) {
                best = cur;
            }
        }
        if (best.length() > len)
            return null;

        StringBuilder ans = new StringBuilder();
        for (int i = best.length(); i < len; i++)
            ans.append('1');
        ans.append(best);
        return ans.toString();
    }
}