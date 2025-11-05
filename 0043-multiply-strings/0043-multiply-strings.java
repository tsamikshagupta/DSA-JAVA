class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int n = num1.length(), m = num2.length();
        int[] result = new int[n + m];  
        for (int i= n-1;i>=0;i--) {
            for (int j = m-1;j>=0;j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                int product = d1 * d2;
                int posLow  = i + j + 1;
                int posHigh = i + j;
                int sum = product + result[posLow];
                result[posLow] = sum % 10;
                result[posHigh] += sum / 10;
            }
        }
        for (int i = n + m - 1; i > 0; i--) {
            if (result[i] >= 10) {
                result[i - 1] += result[i] / 10;
                result[i] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int start = (result[0] == 0) ? 1 : 0;
        for (int i = start; i < n + m; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }
}