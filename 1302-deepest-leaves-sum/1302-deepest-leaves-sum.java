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

    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
     
        int sum = 0;
        Queue<TreeNode> que = new ArrayDeque();
        que.add(root);
        while(que.size() != 0){
            int size  = que.size();
            sum =0;
            while(size-- > 0){
               
                TreeNode rnode = que.remove();
                sum += rnode.val;
                if(rnode.left != null){ 
                    que.add(rnode.left);
                }
                if(rnode.right != null){
                    que.add(rnode.right);
                }
                
            }
         
        }
        return sum;
    }
}