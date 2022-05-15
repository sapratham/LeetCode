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
    public int dfs(TreeNode root ){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left );
        int right = dfs(root.right);
        
        return Math.max(left , right ) + 1;
    }
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        int count =  dfs(root);
        int sum = 0;
        Queue<TreeNode> que = new ArrayDeque();
        que.add(root);
        while(que.size() != 0){
            int size  = que.size();
            while(size-- > 0){
                TreeNode rnode = que.remove();
                
                if(rnode.left != null){ 
                    que.add(rnode.left);
                }
                if(rnode.right != null){
                    que.add(rnode.right);
                }
            }
            count--;
                if(count == 1){
                    while(que.size() != 0){
                        sum += que.remove().val;
                    }
                }
            
        }
        return sum;
    }
}