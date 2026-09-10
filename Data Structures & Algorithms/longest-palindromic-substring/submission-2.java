class Solution {

    private Boolean[][] dp;

    private boolean solve(String s, int i, int j) {

        // Base case
        if (i >= j) {
            return true;
        }

        // Already calculated
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        // First and last characters must match
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solve(s, i + 1, j - 1);
        }

        return dp[i][j] = false;
    }

    public String longestPalindrome(String s) {

        int n = s.length();

        dp = new Boolean[n][n];

        int st = 0;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                if (solve(s, i, j)) {

                    int len = j - i + 1;

                    if (len > maxLen) {
                        maxLen = len;
                        st = i;
                    }
                }
            }
        }

        return s.substring(st, st + maxLen);
    }
}