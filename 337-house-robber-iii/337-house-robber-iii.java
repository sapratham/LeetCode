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
    HashMap<TreeNode , Integer> map;
    public int rob(TreeNode root) {
        map = new HashMap();
        return dfs(root);
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }
        int rob = root.val;
        if(root.left != null){
           rob += dfs(root.left.left) + dfs(root.left.right);
        }
        if(root.right != null){
           rob += dfs(root.right.left) + dfs(root.right.right);
        }
        
        int notrob = dfs(root.left) + dfs(root.right);
        
        int res =  Math.max(rob , notrob);
        map.put(root , res);
        
        return res;
    }
}