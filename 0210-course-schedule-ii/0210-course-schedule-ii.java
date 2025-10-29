class Solution {
    public int[] findOrder(int numCourses,int[][] prerequisites) {
        List<Integer>[] adj=new ArrayList[numCourses];
        for (int i=0; i<numCourses; i++) {
            adj[i]= new ArrayList<>();
        }
        int[] indegree = new int[numCourses];
        for (int[] pre:prerequisites) {
            int ai = pre[0],bi = pre[1];
            adj[bi].add(ai);      
            indegree[ai]++;       
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<numCourses;i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
         
        while(!queue.isEmpty()){
            int curr = queue.poll();
            result.add(curr);  
            for(int neighbor:adj[curr]) {
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        if(result.size() == numCourses){
            int[] order = new int[numCourses];
            for(int i=0;i<numCourses;i++) {
                order[i] = result.get(i);
            }
            return order;
        } else{
            return new int[0];  
        }
        
    }
}