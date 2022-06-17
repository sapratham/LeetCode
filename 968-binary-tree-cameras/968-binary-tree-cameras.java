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
    final int  C = 1;
    final int M = 2;
    final int NM = 3;
    public int minCameraCover(TreeNode root) {
      int val =  postOrderCheck(root);
        if(val == NM){
            count++;
        }
        return count;
    }
    public int postOrderCheck(TreeNode root){
        if(root == null){
            return M;
        }
        
       int left = postOrderCheck(root.left);
       int right = postOrderCheck(root.right);
        
       if(left == M && right == M){
           return NM;
       }else if(left == NM || right == NM){
           count++;
           return C;
       }else{
           return M;
       }
    }
}