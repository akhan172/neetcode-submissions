class Solution {
    private boolean isSame(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        else if((p==null && q != null) || (p!=null && q==null)){
            return false;
        }
        else if(p.val != q.val){
            return false;
        }
        return (isSame(p.left, q.left) && isSame(p.right, q.right));
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p, q);
    }
}
