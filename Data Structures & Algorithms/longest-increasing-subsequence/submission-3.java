class Solution {
    Integer[][] dp;

    private int solve(int i, int prev, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[i][prev + 1] != null) {
            return dp[i][prev + 1];
        }

        // Take
        int take = 0;

        if (prev == -1 || nums[i] > nums[prev]) {
            take = 1 + solve(i + 1, i, nums);
        }

        // Skip
        int skip = solve(i + 1, prev, nums);

        return dp[i][prev + 1] = Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        dp = new Integer[n][n + 1];

        return solve(0, -1, nums);
    }
}