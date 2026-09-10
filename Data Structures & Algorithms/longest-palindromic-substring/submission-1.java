class Solution {
    private boolean solve(String s, int i, int j){
        if(i>=j){
            return true;
        }
        if(s.charAt(i)==s.charAt(j)){
            return solve(s, i+1, j-1);
        }

        return false;
    }
    public String longestPalindrome(String s) {
        int st = -1;
        int maxLen = Integer.MIN_VALUE;

        for(int i=0; i< s.length(); i++){
            for(int j=i; j< s.length(); j++){

                if(solve(s, i, j)){
                    if(j-i+1 > maxLen){
                        maxLen=j-i+1;
                        st=i;
                    }
                }
            }
        }
        
        return s.substring(st, st+maxLen);
    }
}
