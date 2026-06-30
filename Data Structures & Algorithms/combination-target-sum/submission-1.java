class Solution {
    private void solve(int[] nums, int target, int idx, List<Integer> curr, List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target <0 || idx>=nums.length){
            return;
        }
        curr.add(nums[idx]);
        solve(nums, target-nums[idx], idx, curr, ans);
        curr.remove(curr.size()-1);

        solve(nums, target, idx+1, curr, ans);

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, target, 0, new ArrayList<Integer>(), ans);
        return ans;
    }
}
