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
    TreeNode node = new TreeNode(-1);
    public TreeNode increasingBST(TreeNode root) {
      if(root == null) return null;
          TreeNode res = node;
       inorder(root);
        return res.right;
        
    }
    public void inorder(TreeNode root){
         if(root == null) return;
        increasingBST(root.left);
        node.right = new TreeNode(root.val);
        node = node.right;
        increasingBST(root.right);
    }
}