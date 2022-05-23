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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 1 && postorder.length == 1) return new TreeNode(inorder[0]);
          
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            int val = inorder[i];
            map.put(val , i);
        }
        
        TreeNode root = construct(0, inorder.length - 1 , 0 , postorder.length - 1, postorder , map);
        
        return root;
    }
    public TreeNode construct(int instart , int inend , int poststart , int postend , int[] post, HashMap<Integer,Integer> map){
        if(instart > inend || poststart > postend) return null;
        
        TreeNode node = new TreeNode();
        node.val = post[postend];
        
        int index  =  map.getOrDefault(post[postend] , 0);
        int rhs = inend - index;
        
        node.left = construct(instart , index - 1 , poststart , postend - rhs - 1 , post , map);
        node.right = construct(index + 1 , inend , postend - rhs , postend - 1, post ,map);
        
        return node;
    }
}