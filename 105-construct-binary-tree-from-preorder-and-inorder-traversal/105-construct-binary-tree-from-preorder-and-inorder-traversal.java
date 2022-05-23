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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 1 && inorder.length == 1) return new TreeNode(preorder[0] , null , null);
        
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < inorder.length ; i++){
            int val = inorder[i];
            map.put(val , i);
        }
        
        TreeNode root = construct(0,preorder.length - 1 , 0 , inorder.length - 1 , preorder , map);
        
        return root;
    }
    public TreeNode construct(int prestart , int preend , int instart , int inend , int[] pre , HashMap<Integer,Integer> map){
        if(preend < prestart || inend < instart) return null;
        
        TreeNode node = new TreeNode();
        node.val = pre[prestart];
        int index = map.get(pre[prestart]);
        int lhs = index - instart;
        
        node.left = construct(prestart + 1, preend + lhs , instart , index - 1 , pre , map);
        node.right = construct(prestart + lhs + 1 , preend , index + 1 , inend , pre , map);
        
        return node;
    }
}