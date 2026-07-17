class Solution {
    private int[] dp;
    private int solve (int[] nums, int idx){
        if(idx >= nums.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }

        int rob = nums[idx]+ solve(nums, idx+2);

        int skip= solve(nums, idx+1);

        return dp[idx]=Math.max(rob, skip);
    }
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, 0);
    }
}
