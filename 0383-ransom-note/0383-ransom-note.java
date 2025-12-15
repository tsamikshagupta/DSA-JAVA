class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransom = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();

        for (int i = 0; i < ransom.length; i++) {
            boolean found = false;

            for (int j = 0; j < mag.length; j++) {
                if (ransom[i] == mag[j]) {
                    mag[j] = '#'; 
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        return true;
    }
}