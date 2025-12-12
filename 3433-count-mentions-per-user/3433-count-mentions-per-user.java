class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if (t1 != t2) return t1 - t2;
            return a.get(0).equals("OFFLINE") ? -1 : 1;
        });

        int[] mentions = new int[numberOfUsers];
        boolean[] online = new boolean[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers];

        for (int i = 0; i < numberOfUsers; i++) {
            online[i] = true;
            offlineUntil[i] = -1;
        }

        for (List<String> event : events) {

            String type = event.get(0);
            int timestamp = Integer.parseInt(event.get(1));

            for (int i = 0; i < numberOfUsers; i++) {
                if (!online[i] && offlineUntil[i] <= timestamp) {
                    online[i] = true;
                }
            }

            if (type.equals("OFFLINE")) {
                int id = Integer.parseInt(event.get(2));
                online[id] = false;
                offlineUntil[id] = timestamp + 60;

            } else { 
                String mentionStr = event.get(2);

                if (mentionStr.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        mentions[i]++;
                    }
                }
                else if (mentionStr.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (online[i]) {
                            mentions[i]++;
                        }
                    }
                }
                else {
                    String[] tokens = mentionStr.split(" ");
                    for (String token : tokens) {
                        int id = Integer.parseInt(token.substring(2));
                        mentions[id]++;
                    }
                }
            }
        }

        return mentions;
    }
}