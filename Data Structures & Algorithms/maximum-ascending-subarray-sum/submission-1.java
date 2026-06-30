class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int psum = nums[0];
        int prev = nums[0];

        for(int  i=1; i<nums.length; i++){
            ans = Math.max(ans, psum);
            if(nums[i]>prev){
                psum +=nums[i];
            }else{
                psum = nums[i];
            }
            ans = Math.max(ans, psum);
            prev = nums[i];
        }
        return ans;
        
    }
}