class Solution {
    private int expand(String s, int l, int r){
        int cnt=0;
        while(l>=0 && r<s.length()){
            if(!(s.charAt(l)==s.charAt(r))){
                break;
            }

            cnt++;
            l--;
            r++;
        }
        return cnt;
    }
    public int countSubstrings(String s) {
        int n=s.length();
        int ans=0;

        for(int i=0; i<n; i++){
            int a=expand(s, i, i);
            int b=expand(s, i, i+1);

            ans+=a+b;
        }
        return ans;
    }
}
