class Solution {
    
    private boolean dfs(int node, int pt, boolean[] visited, List<Integer>[] mp) {
        visited[node] = true;

        for (int nd : mp[node]) {
            if (nd == pt) {
                continue;
            }
            if (visited[nd]) {
                return true;
            }
            if (dfs(nd, node, visited, mp)) {
                return true;
            }
        }
        return false;
    }
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        List<Integer>[] mp = new ArrayList[n];

        // initializing the map
        for (int i = 0; i < n; i++) {
            mp[i] = new ArrayList<>();
        }

        // making adjacecy list
        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];

            mp[u].add(v);
            mp[v].add(u);
        }

        boolean[] visited = new boolean[n];

        if (dfs(0, -1, visited, mp)) {
            return false;
        }

        for (boolean nd : visited) {
            if (!nd) {
                return false;
            }
        }

        return true;
    }
}
