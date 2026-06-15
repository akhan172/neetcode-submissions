class Solution {
    public int characterReplacement(String s, int k) {
        int left=0; 
        int right=0;
        int maxfreq=0;
        int ans=0;

        int[] arr = new int[26];
        while(right<s.length()){
            int idx = (int)s.charAt(right)-'A';
            arr[idx]++;

            maxfreq = Math.max(maxfreq, arr[idx]);
            if(((right-left)+1)-maxfreq > k){
                arr[(int)s.charAt(left)-'A']--;
                left++;
            }

            ans = Math.max(ans, (right-left)+1);
            right++;
        }
        return ans;
    }
}
