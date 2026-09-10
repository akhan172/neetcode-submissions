class Solution {
    private Boolean[][] dp;
    private boolean solve(String s, int i, int j){
        if(i>=j){
            return true;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]=solve(s, i+1, j-1);
        }
        return dp[i][j]=false;
    }
    public int countSubstrings(String s) {
        int ans=0;
        int n=s.length();
        dp =new Boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){

                if(solve(s, i, j)){
                    ans++;
                }
            }
        }
        return ans;
    }
}
