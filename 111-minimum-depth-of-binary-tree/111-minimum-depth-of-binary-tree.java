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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> que = new ArrayDeque();
        que.add(root);
        int level = 1;
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                TreeNode rnode = que.remove();
                if(rnode.left == null && rnode.right == null) return level;
                if(rnode.left != null) que.add(rnode.left);
                if(rnode.right != null) que.add(rnode.right);
            }
            level++;
        }
        return level;
    }
    
}