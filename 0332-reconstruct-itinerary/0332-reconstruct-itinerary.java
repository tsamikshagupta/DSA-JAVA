class Solution {
    Map<String , PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> route = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> t : tickets){
            String from = t.get(0);
            String to = t.get(1);
                graph.putIfAbsent(from , new PriorityQueue<>());
                graph.get(from).add(to);

        }
        dfs("JFK");
        return route;
        
    }
    void dfs(String src){
        PriorityQueue<String> pq = graph.get(src);
        while(pq!=null && !pq.isEmpty()){
            dfs(pq.poll());
        }
        route.addFirst(src);
    }

}