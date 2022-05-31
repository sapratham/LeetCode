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
    int count = 0;
    final int C = 1;
    final int M = 2;
    final int NM = 3;
    
    public int minCameraCover(TreeNode root) {
       int val = helper(root);
        if(val == NM) {
            count++;
        }
        return count;
    }
    public int helper(TreeNode root){
        if(root == null){
            return M;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        
        if(left == NM || right == NM){
            count++;
            return C;
        }else if(left == C || right == C){
            return M;
        }else{
            return NM;
        }
    }
}