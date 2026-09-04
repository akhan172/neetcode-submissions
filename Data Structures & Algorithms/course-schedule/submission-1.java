class Solution {
    private boolean dfsCycle(int i, boolean[] indegree, List<Integer>[] adj, boolean[] visited){
        visited[i] = true;
        indegree[i] = true;

        for(int v: adj[i]){
            if(!visited[v] && dfsCycle(v, indegree, adj, visited)){
                return true;
            }
            else if(indegree[v]){
                return true;
            }
        }
        indegree[i] = false;
        return false;
    }
    public boolean canFinish(int num, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[num];

        for(int i=0; i<num; i++){
            adj[i] = new ArrayList<>();
        }

        for(int arr[]:prerequisites){
            int u = arr[0];
            int v = arr[1];
            adj[u].add(v);
        }

        boolean[] visited = new boolean[num];
        boolean[] indegree = new boolean[num];

        for(int i=0; i<num; i++){
           if(!visited[i] && dfsCycle(i, indegree, adj, visited)){
                return false;
           }

        }
        return true;
    }
}
