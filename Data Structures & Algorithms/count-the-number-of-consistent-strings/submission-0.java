class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] arr = new int[26];
        for(char ch: allowed.toCharArray()){
            arr[(int)ch-'a']++;
        }
        int ans=0;
        for(String word: words){
            int flag=0;
            for(char ch:word.toCharArray()){
                flag=0;
                if(arr[(int)ch-'a']<1){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                ans++;
            }
        }
        return ans;
    }
}