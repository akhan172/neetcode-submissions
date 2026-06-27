class Solution {
    private int ans = Integer.MIN_VALUE;
    private int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = solve(root.left);
        int r = solve(root.right);

        int poss1 = l+r+ root.val;
        int poss2 = Math.max(l,r)+root.val;
        int poss3 = root.val;

        ans = Math.max(ans, Math.max(poss3, Math.max(poss2, poss1)));

        return Math.max(poss2, poss3);
    }
    public int maxPathSum(TreeNode root) {
        solve(root);
        return ans;
    }
}
