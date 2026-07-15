class Solution {
    private Map<Integer, List<Integer>> mp;
    private boolean dfs(int node, int pt, boolean[] visited){
        visited[node] = true;

        for(int nd : mp.get(node)){
            if(nd == pt){
                continue;
            }
            if(visited[nd]){
                return true;
            }
            if(dfs(nd, node, visited)){
                return true;
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        mp = new HashMap<>();

        //initializing the map
        for(int i=0; i<n; i++){
            mp.put(i, new ArrayList<>());
        }
        
        //making adjacecy list
        for(int[] arr: edges){
            int u=arr[0];
            int v=arr[1];

            mp.get(u).add(v);
            mp.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        
        if(dfs(0, -1, visited)){
            return false;
        }

        for(boolean nd: visited){
            if(!nd){
                return false;
            }
        }

        return true;
    }
}
