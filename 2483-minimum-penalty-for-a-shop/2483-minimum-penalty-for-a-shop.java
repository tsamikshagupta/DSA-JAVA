class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int penalty = 0;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') penalty++;
        }
        int bestHour = 0;
        int minpenalty = penalty;
        for (int j = 1; j <= n; j++) {
            char c = customers.charAt(j - 1);
            if (c == 'Y') {
                penalty -= 1;  
            } else { 
                penalty += 1;  
            }
            if (penalty < minpenalty) {
                minpenalty = penalty;
                bestHour = j;
            }
        }

        return bestHour;
        
    }
}