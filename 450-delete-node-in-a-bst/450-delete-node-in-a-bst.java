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
    
    public static int min(TreeNode node){
        
        if(node.left==null||node==null){
            return node.val;
        }
        else{
            return min(node.left);
        }
    }
    
    public TreeNode deleteNode(TreeNode node, int data) {
        if(node==null){//conner case
            return null;
        }
        
        if(node.val>data){
            node.left=deleteNode(node.left,data);
        }
        else if(node.val<data){
            node.right=deleteNode(node.right,data);
            
        }
        else{
            
            if( node.left==null&&node.right==null){
                return null;
            }
            else if(node.right==null){
                return node.left;
            }
            else if(node.left==null){
                return node.right;
            }
            else{
                int rmin= min(node.right);
                node.val=rmin;
                node.right=deleteNode(node.right,rmin);
                
            }
        }
        return node;
    }
}