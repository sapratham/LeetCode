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
    TreeNode first = null, second = null,prev = null;
    public void recoverTree(TreeNode root) {
        if(root == null) return ;
          solve(root);
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
     
    }
    public void solve(TreeNode root){
        if(root == null) return;
        solve(root.left);
        if( prev != null && prev.val > root.val){
            if(first == null) first = prev;
           second = root;
        }
        prev = root;
        solve(root.right);
    }
}