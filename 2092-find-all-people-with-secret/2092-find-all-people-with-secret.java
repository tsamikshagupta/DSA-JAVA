class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));
        Set<Integer> secret = new HashSet<>();
        secret.add(0);
        secret.add(firstPerson);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            Map<Integer, Integer> parent = new HashMap<>();

            for (int j = i; j < meetings.length && meetings[j][2] == time; j++) {
                parent.put(meetings[j][0], meetings[j][0]);
                parent.put(meetings[j][1], meetings[j][1]);
            }

            java.util.function.Function<Integer, Integer> find = new java.util.function.Function<>() {
                public Integer apply(Integer x) {
                    if (!parent.get(x).equals(x)) {
                        parent.put(x, apply(parent.get(x)));
                    }
                    return parent.get(x);
                }
            };

            for (int j = i; j < meetings.length && meetings[j][2] == time; j++) {
                int x = meetings[j][0];
                int y = meetings[j][1];
                int px = find.apply(x);
                int py = find.apply(y);
                if (px != py) parent.put(px, py);
            }

            Map<Integer, List<Integer>> groups = new HashMap<>();
            for (int person : parent.keySet()) {
                int root = find.apply(person);
                groups.computeIfAbsent(root, k -> new ArrayList<>()).add(person);
            }
            for (List<Integer> group : groups.values()) {
                boolean hasSecret = false;
                for (int person : group) {
                    if (secret.contains(person)) {
                        hasSecret = true;
                        break;
                    }
                }
                if (hasSecret) {
                    secret.addAll(group);
                }
            }
            while (i < meetings.length && meetings[i][2] == time) {
                i++;
            }
        }

        return new ArrayList<>(secret); 
    }
}