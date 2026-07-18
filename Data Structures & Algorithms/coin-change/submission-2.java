class Solution {
    private int[] dp;
    private int solve(int[] coins, int amt){
        if(amt == 0){
            return 0;
        }
        if(amt < 0){
            return -1;
        }
        if(dp[amt] != -2){
            return dp[amt];
        }
        
        int res = Integer.MAX_VALUE;
        
        for(int c : coins){
            int ans = solve(coins, amt - c);
            
            // FIX: Only add 1 if ans is valid AND won't cause an overflow
            if(ans != -1 && ans != Integer.MAX_VALUE) {
                res = Math.min(res, ans + 1);
            }
        }
        return dp[amt] = res;
    }
    
    public int coinChange(int[] coins, int amount) {
        dp = new int[10001];
        Arrays.fill(dp, -2);
        int an = solve(coins, amount);
        return an == Integer.MAX_VALUE ? -1 : an;
    }
}