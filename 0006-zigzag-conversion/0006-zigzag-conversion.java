class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] arr = new StringBuilder[numRows];
        for (int j = 0; j < numRows; j++) {
            arr[j] = new StringBuilder();
        }

        int cr = 0, i = 0, mod = 0; 
        int[] dir = {1, -1}; 

        while (i < s.length()) {
            arr[cr].append(s.charAt(i)); 
            i++;
            int newRow = cr + dir[mod]; 
            if (newRow < 0 || newRow >= numRows) { 
                mod = (mod + 1) % 2; 
                newRow = cr + dir[mod]; 
            }
            cr = newRow; 
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder st : arr) {
            res.append(st);
        }
        return res.toString();
    }
}