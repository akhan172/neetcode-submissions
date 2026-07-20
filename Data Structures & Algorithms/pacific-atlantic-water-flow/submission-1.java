class Solution {

    private int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    private void dfs(int i, int j, int[][] heights, boolean[][] visited) {
        visited[i][j] = true;

        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni < 0 || nj < 0 || ni >= heights.length || nj >= heights[0].length) {
                continue;
            }

            if (visited[ni][nj]) {
                continue;
            }

            // Reverse flow
            if (heights[ni][nj] < heights[i][j]) {
                continue;
            }

            dfs(ni, nj, heights, visited);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific: Top row
        for (int j = 0; j < n; j++) {
            dfs(0, j, heights, pacific);
        }

        // Pacific: Left column
        for (int i = 0; i < m; i++) {
            dfs(i, 0, heights, pacific);
        }

        // Atlantic: Bottom row
        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, heights, atlantic);
        }

        // Atlantic: Right column
        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, heights, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }
}