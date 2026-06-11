class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> st = new HashSet<>();
        for(int n:nums){
            st.add(n);
        }
        for(int n: nums){
            if(!st.contains(n-1)){
                int l=1;
                while(st.contains(n+l)){
                    l++;
                }
                ans = Math.max(l,ans);
            }
            
        }
        return ans;
    }
}
