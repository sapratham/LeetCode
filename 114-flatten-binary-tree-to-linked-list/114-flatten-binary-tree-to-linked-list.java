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
    public void flatten(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> que = new LinkedList<>();
        preOrderTraversal(root,que);
        while(!que.isEmpty()){
            TreeNode currNode = que.poll();
            currNode.left = null;
            currNode.right = que.peek();
        }
    }
        private void preOrderTraversal(TreeNode root, Queue<TreeNode> que){
            if(root == null) return;
            que.add(root);
            preOrderTraversal(root.left, que);
            preOrderTraversal(root.right,que);
        }
    
}