class Solution {  
    private boolean checkT(TreeNode a, TreeNode b){
        if(a==null && b==null){
            return true;
        }
        else if(a==null || b==null){
            return false;
        }
        if (a.val != b.val) return false;
        return (checkT(a.left, b.left) && checkT(a.right, b.right));
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        if (checkT(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
