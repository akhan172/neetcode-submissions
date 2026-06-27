class Solution {
    private Map<Integer, Integer> mp = new HashMap<>();
    private int idx = 0;

    private TreeNode solve(int[] preorder, int[] inorder, int st, int en){
        if(st>en){
            return null;
        }
        int rootval = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootval);

        root.left  = solve(preorder, inorder, st, mp.get(rootval)-1);
        root.right = solve(preorder, inorder, mp.get(rootval)+1, en);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        for(int i=0; i<n; i++){
            mp.put(inorder[i], i);
        }

        return solve(preorder, inorder, 0, n-1);
    }
}
