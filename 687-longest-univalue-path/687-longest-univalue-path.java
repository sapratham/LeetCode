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
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root, -1);
        return (res > 0)? res-1 : res ;
    }
    public int helper(TreeNode root , int val){
        if(root == null){
            return 0;
        }
        int left = helper(root.left , root.val);
        int right = helper(root.right , root.val);
        
       res = Math.max((left+right+1),res);
        
        if(root.val == val){
            return Math.max(left,right) + 1;
        }else{
            return 0;
        }
    }
}