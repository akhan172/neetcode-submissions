class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(
        int idx, int[] candidates, int target, List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (idx == candidates.length || target < 0) {
            return;
        }

        // Pick the current element
        curr.add(candidates[idx]);
        backtrack(idx, candidates, target - candidates[idx], curr, ans);
        curr.remove(curr.size() - 1);

        // Skip the current element
        backtrack(idx + 1, candidates, target, curr, ans);
    }
}