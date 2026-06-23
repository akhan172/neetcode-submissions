class Solution {
    private boolean checkBst(TreeNode root, int left, int right){
        if(root == null){
            return true;
        }
        else if(root.val>left && root.val<right){
            return( checkBst(root.left, left, root.val) &&
                    checkBst(root.right, root.val, right));
        }
        return false;
        
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        else if(root.left == null && root.right == null){
            return true;
        }else{
            return checkBst(root, -1001, 1001);
        }
    }
}
