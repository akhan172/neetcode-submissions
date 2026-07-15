class Solution {
    private Map<Integer, List<Integer>> mp;
    private boolean dfs(int node, int parent, boolean[] visited){
        visited[node] = true;

        for(int ng: mp.get(node)){
            if(ng == parent){
                continue;
            }
            if(visited[ng]){
                return true;
            }
            if(dfs(ng, node, visited)){
                return true;
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
    mp.put(i, new ArrayList<>());
}
        for(int[] arr : edges){
            int u = arr[0];
            int v = arr[1];

            // mp.putIfAbsent(u, new ArrayList<Integer>());
            // mp.putIfAbsent(v, new ArrayList<Integer>());


            mp.get(u).add(v);
            mp.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        if(dfs(0, -1, visited)){
            return false;
        }
        // Check if graph is connected
        for (boolean node : visited) {
            if (!node) {
                return false;
            }
        }

        return true;

    }
}
