class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(startGene);
        visited.add(startGene);
        int mutations = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(endGene)) {
                    return mutations;
                }
                char[] arr = curr.toCharArray();
                for (int j = 0; j < 8; j++) {
                    char original = arr[j];
                    for (char ch : genes) {
                        if (ch == original) {
                            continue;
                        }
                        arr[j] = ch;
                        String next = new String(arr);
                        if (bankSet.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                    arr[j] = original;
                }
            }

            mutations++;
        }

        return -1;
    }
}