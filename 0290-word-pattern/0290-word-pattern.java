class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
         for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String w = words[i];

            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(w)) return false;
            } else {
                charToWord.put(ch, w);
            }

            if (wordToChar.containsKey(w)) {
                if (wordToChar.get(w) != ch) return false;
            } else {
                wordToChar.put(w, ch);
            }
        }

        return true;
        
    }
}