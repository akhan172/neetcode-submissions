/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int idx = 0;
    private Map<Integer, Integer> mp = new HashMap<>();
    private TreeNode build(int[] preorder, int[] inorder, int st, int en){
        if(st>en){
            return null;
        }
        int rootVal = preorder[idx];
        idx++;
        int i=mp.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.left = build(preorder, inorder, st, i-1);
        root.right = build(preorder, inorder, i+1, en);

        return root;

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;

        for(int i=0; i<n; i++){
            mp.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, n-1);
    }
}
