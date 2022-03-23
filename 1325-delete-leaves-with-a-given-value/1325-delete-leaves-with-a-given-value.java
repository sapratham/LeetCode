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
        // if(root.left == null && root.right == null && root.val == target){
        //     return null;
        // }
        TreeNode leftside = removeLeafNodes(root.left , target);
        TreeNode rightside = removeLeafNodes(root.right , target);
        root.left = leftside;
        root.right = rightside;
         if(root.left == null && root.right == null && root.val == target){
            return null;
        }
        return root;
    }
}