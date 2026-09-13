class Solution {
    Integer[] dp;
    private int solve(String s, int i, int n) {

        // Successfully reached the end
        if(i == n){
            return 1;
        }

        // 0 cannot be decoded by itself
        if(s.charAt(i) == '0'){
            return 0;
        }

        if(dp[i] != null){
            return dp[i];
        }

        // Take one digit
        int single = solve(s, i + 1, n);

        int two = 0;

        // Take two digits
        if(i + 1 < n) {

            two = (s.charAt(i) - '0') * 10
                + (s.charAt(i + 1) - '0');

            if(two >= 10 && two <= 26){
                two = solve(s, i + 2, n);
            } else {
                two = 0;
            }
        }

        return dp[i]=single + two;
    }

    public int numDecodings(String s) {
        dp = new Integer[101];
        return solve(s, 0, s.length());
    }
}