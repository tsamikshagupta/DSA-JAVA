class Solution {
    public String makeLargestSpecial(String s) {
        List<String> blocks = new ArrayList<>();
        int balance = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            balance += (s.charAt(i) == '1') ? 1 : -1;
            if (balance == 0) {
                String inner = s.substring(start + 1, i);
                String optimizedInner = makeLargestSpecial(inner);
                blocks.add("1" + optimizedInner + "0");
                start = i + 1;
            }
        }
        Collections.sort(blocks, Collections.reverseOrder());
        StringBuilder result = new StringBuilder();
        for (String block : blocks) {
            result.append(block);
        }
        return result.toString();
    }
}