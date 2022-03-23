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
    static int maxPathSum ;
    
    public int pathSum(TreeNode root){
        if(root == null) return 0;
        
        int pathFromleft = pathSum(root.left);
        int pathFromright = pathSum(root.right);
        int pathFromleftIncludingRoot = pathFromleft + root.val;
        int pathFromrightIncludingRoot = pathFromright + root.val;
        int bestIncludingroot = Math.max(pathFromrightIncludingRoot , pathFromleftIncludingRoot);
        int allPath = pathFromleft + pathFromright + root.val;
        maxPathSum = Math.max(maxPathSum, Math.max(root.val,Math.max(allPath, Math.max(pathFromleftIncludingRoot,pathFromrightIncludingRoot))));
        
        return Math.max(root.val , Math.max(pathFromleftIncludingRoot , pathFromrightIncludingRoot));
    }
    
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        pathSum(root);
        return maxPathSum;
    }
}