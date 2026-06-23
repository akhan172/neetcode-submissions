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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        while(!dq.isEmpty()){
            int size=dq.size();
            List<Integer> ta = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode topa = dq.poll();
                ta.add(topa.val);

                if(topa.left != null){
                    dq.offer(topa.left);
                }
                if(topa.right != null){
                    dq.offer(topa.right);
                }
            }
            ans.add(ta);
        }
        return ans;
        
    }
}
