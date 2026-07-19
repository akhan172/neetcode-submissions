class Solution {
    //Two condition to follow
    //1. No loops
    //2. All connected
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[n];
        //Check for cycle
        if(dfs(adj, visited, 0, -1)){
            return false;
        }

        //check for connected
        for(boolean flg:visited){
            if(!flg){
                return false;
            }
        }
        return true;

    }
    //Doing DFS for cycle check
    private boolean dfs(List<Integer>[] adj, boolean[] visited, int node, int pt){
        visited[node] = true;

        for(int nds: adj[node]){
            if(nds == pt){
                continue;
            }
            if(visited[nds] == true){
                return true;
            }
            if(dfs(adj, visited, nds, node)){
                return true;
            }
        }
        return false;
    }
}
