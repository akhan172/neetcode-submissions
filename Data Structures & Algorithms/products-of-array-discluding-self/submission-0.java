class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int pro = 1;
        int flag = 0;
        for(int n : nums){
            if(n == 0){
                flag++;
                continue;}
            pro = pro*n;
        }
        if(flag > 1)return ans;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=0 && flag == 1){
                continue;
            }
            else if(nums[i] == 0){
                ans[i] = pro;
            }
            else{
                ans[i]=pro/nums[i];
            }
        }
        return ans;
    }
}  
