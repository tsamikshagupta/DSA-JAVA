class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!dict.contains(endWord)) return result;
        Map<String, List<String>> parents = new HashMap<>();

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        if (dict.contains(beginWord)) dict.remove(beginWord);
        boolean found = false;
        while (!q.isEmpty() && !found) {
            int size = q.size();
            Set<String> visitedThisLevel = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String word = q.poll();
                char[] arr = word.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char original = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[j] = c;
                        String next = new String(arr);
                        if (dict.contains(next)) {
                            parents.computeIfAbsent(next, k -> new ArrayList<>()).add(word);
                            visitedThisLevel.add(next);
                            if (next.equals(endWord)) {
                                found = true;
                            }
                        }
                    }
                    arr[j] = original;
                }
            }
            for (String w : visitedThisLevel) q.offer(w);
            dict.removeAll(visitedThisLevel);
        }
        if (!found) return result;
        List<String> path = new ArrayList<>();
        path.add(endWord);
        backtrack(endWord, beginWord, parents, path, result);
        return result;
        
    }
    private void backtrack(String word, String beginWord,
                           Map<String, List<String>> parents,
                           List<String> path, List<List<String>> result) {

        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        if (!parents.containsKey(word)) return;
        for (String p : parents.get(word)) {
            path.add(p);
            backtrack(p, beginWord, parents, path, result);
            path.remove(path.size() - 1);
        }
    }
}