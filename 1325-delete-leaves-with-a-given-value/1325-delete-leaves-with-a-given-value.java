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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return null;
        TreeNode leftside = removeLeafNodes(root.left , target);
        TreeNode rightside = removeLeafNodes(root.right , target);
        
        if(leftside == null && rightside == null && root.val == target){
            return null;
        }
        
        root.left = leftside;
        root.right = rightside;
         
        return root;
    }
}