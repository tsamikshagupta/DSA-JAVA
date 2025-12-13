class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
          List<String> order = Arrays.asList(
            "electronics", "grocery", "pharmacy", "restaurant"
        );
        
        Map<String, List<String>> map = new HashMap<>();
        for (String b : order) {
            map.put(b, new ArrayList<>());
        }

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i]) continue;

            if (code[i] == null || code[i].isEmpty()) continue;
            if (!code[i].matches("[a-zA-Z0-9_]+")) continue;

            if (!map.containsKey(businessLine[i])) continue;
            map.get(businessLine[i]).add(code[i]);
        }

        List<String> result = new ArrayList<>();
        for (String b : order) {
            List<String> list = map.get(b);
            Collections.sort(list);
            result.addAll(list);
        }

        return result;
        
    }
}