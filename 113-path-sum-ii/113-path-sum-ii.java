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
    List<List<Integer>> paths = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       if(root == null) return paths;
        
        dfs(root,targetSum , new ArrayList<>());
        return paths;
    }
    public void dfs(TreeNode root , int target , ArrayList<Integer> path){
        if(root == null) return;
        
        path.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null) paths.add(path);
        dfs(root.left , target ,new ArrayList<>(path));
        dfs(root.right , target ,new ArrayList<>(path));
    }
}