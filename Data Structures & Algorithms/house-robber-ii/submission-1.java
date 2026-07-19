class Solution {

    private int solve(int[] nums, int idx, int l, int[] dp) {

        if (idx >= l)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int rob = nums[idx] + solve(nums, idx + 2, l, dp);
        int skip = solve(nums, idx + 1, l, dp);

        return dp[idx] = Math.max(rob, skip);
    }

    public int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        return Math.max(
                solve(nums, 0, nums.length - 1, dp1), // houses 0 to n-2
                solve(nums, 1, nums.length, dp2)       // houses 1 to n-1
        );
    }
}