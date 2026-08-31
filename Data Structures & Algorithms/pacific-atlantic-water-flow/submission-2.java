class Solution {
    private int[][] dir = {{1,0},{0,1}, {0,-1}, {-1,0}};
    private void dfs(int i, int j, int[][] heights, boolean[][] vst){
        vst[i][j]=true;
        for(int[] d:dir){
            int ni=i+d[0];
            int nj=j+d[1];

            //boundary check
            if(ni<0 || nj<0 || ni>= vst.length ||nj>= vst[0].length){
                continue;
            }

            //visited check
            if(vst[ni][nj]){
                continue;
            }

            //reverse flow check
            if(heights[i][j]>heights[ni][nj]){
                continue;
            }
            dfs(ni, nj, heights, vst);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;

        boolean[][] pc = new boolean[m][n];
        boolean[][] at = new boolean[m][n];

        for(int i=0; i<m; i++){
            dfs(i, 0, heights, pc);
        }

        for(int i=0; i<n; i++){
            dfs(0, i, heights, pc);
        }

        for(int i=0; i<n; i++){
            dfs(m-1, i,heights, at);
        }

        for(int i=0; i<m; i++){
            dfs(i, n-1,heights, at);
        }
         List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pc[i][j] && at[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }
}
