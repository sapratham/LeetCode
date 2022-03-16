/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        if(root == p || root == q) return root;
        
        if(p.right == q || p.left == q) return p;
        if(q.right == p || q.right == p) return q;
         
        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right ,p ,q);
        
        if(left != null && right != null) return root;
        
        if(left != null) return left;
        if(right != null) return right;
        return null;
    }
}