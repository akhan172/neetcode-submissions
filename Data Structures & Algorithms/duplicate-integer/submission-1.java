class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0, j=1; j<nums.length; j++, i++){
            if(nums[i]==nums[j]){
                return true;
            }
        }
        return false;
    }
}