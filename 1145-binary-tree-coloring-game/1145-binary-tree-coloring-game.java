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
    int xleft;
    int xright;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int total = size(root,x);
        int otherside = n - (xleft + xright + 1);
        
        int max = Math.max(otherside,Math.max(xleft , xright));
        int rest = n - max;
        return (max < rest)? false:true;
    }
    public int size(TreeNode node , int x){
        if(node == null) return 0;
        
      
        int ls = size(node.left , x);
        int rs = size(node.right ,x);
        
          if(node.val == x ){
            xleft = ls;
            xright = rs;
        }
        int ts = rs + ls + 1;
        return ts;
    }
}