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
        Queue<TreeNode> que = new ArrayDeque<>();
        preOrder(root , que);
        while(que.size() != 0){
            TreeNode node = que.remove();
           node.left = null;
            node.right = que.peek();
        }
    }
    public void preOrder(TreeNode root , Queue<TreeNode> que){
        if(root == null) return;
        que.add(root);
        preOrder(root.left , que);
        preOrder(root.right , que);
    }
}