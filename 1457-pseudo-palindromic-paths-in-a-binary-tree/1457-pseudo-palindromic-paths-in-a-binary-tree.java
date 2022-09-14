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
    int result = 0;
    int[] digit;
    public int pseudoPalindromicPaths (TreeNode root) {
        digit = new int[10];
        result = 0 ;
        dfs(root);
        return result;
    }
    public void dfs(TreeNode root){
        if(root == null) return;
        
        digit[root.val]++;
        
        if(root.right == null && root.left == null){
            if(ispalindrome()){
                result++;
            }
        }else{
            dfs(root.left);
            dfs(root.right);
        }
        
        digit[root.val]--;
    }
    
    public boolean ispalindrome(){
        int odd = 0;
        for(int i = 1 ; i <= 9 ; i++){
            if(digit[i] % 2 != 0){
                odd++;
            }
            if(odd > 1){
                return false;
            }
        }
        return true;
    }
}