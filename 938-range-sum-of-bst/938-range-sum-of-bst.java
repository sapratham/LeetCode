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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        int leftsum = rangeSumBST(root.left , low ,high);
        int rightsum = rangeSumBST(root.right ,low ,high);
        if(root.val >= low && root.val <= high) return root.val + rightsum + leftsum;
        else return rightsum + leftsum;
    }
}