class Solution {

    private boolean dfs(int node,
                        int parent,
                        List<Integer>[] graph,
                        boolean[] visited) {

        visited[node] = true;

        for (int neighbor : graph[node]) {

            if (neighbor == parent) {
                continue;
            }

            if (visited[neighbor]) {
                return true;
            }

            if (dfs(neighbor, node, graph, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) {
            return false;
        }

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        if (dfs(0, -1, graph, visited)) {
            return false;
        }

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }
}