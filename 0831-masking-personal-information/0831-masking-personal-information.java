class Solution {
    public String maskPII(String s) {
        if (s.contains("@")) {
            return maskEmail(s);
        } else {
            return maskPhone(s);
        }
    }
    private String maskEmail(String s) {
        s = s.toLowerCase();
        int atIndex = s.indexOf('@');
        String name = s.substring(0, atIndex);
        String domain = s.substring(atIndex);
        return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + domain;
    }

    private String maskPhone(String s) {
        StringBuilder digits = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            }
        } 
        int len = digits.length();
        String last4 = digits.substring(len - 4);
        int countryCodeLen = len - 10;
        StringBuilder result = new StringBuilder();
        
        if (countryCodeLen > 0) {
            result.append("+");
            for (int i = 0; i < countryCodeLen; i++) {
                result.append("*");
            }
            result.append("-");
        }
        
        result.append("***-***-").append(last4);
        return result.toString();
    }
}