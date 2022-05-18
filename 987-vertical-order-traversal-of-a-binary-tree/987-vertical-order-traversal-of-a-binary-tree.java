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
   public class Pair implements Comparable<Pair>{
            TreeNode node;
            int idx; // imagine it like a number line
            int depth;
            Pair(TreeNode node, int idx, int depth){
                this.node = node;
                this.idx = idx;
                this.depth = depth;
            }
            
            public int compareTo(Pair o){
                if(this.depth != o.depth){
                    return this.depth - o.depth;
                }else{
                    return this.node.val - o.node.val;
                }
            }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        int lv = 0; // left vertex
        int rv = 0; // right vertex
        q.add(new Pair(root, 0,1));
        
        while(q.size() > 0){
            Pair temp = q.remove();
            
            if(temp.idx > rv){
                rv = temp.idx;
            }else if(temp.idx < lv){
                lv = temp.idx;
            }
            
            if(!map.containsKey(temp.idx)){
                map.put(temp.idx, new ArrayList<Pair>());
                map.get(temp.idx).add(temp); // map.get(temp.idx) gave you a arraylist of that idx.
            }else{
                map.get(temp.idx).add(temp);
            }
            
            if(temp.node.left != null){
                q.add(new Pair(temp.node.left, temp.idx - 1, temp.depth + 1));
            }
            if(temp.node.right != null){
                q.add(new Pair(temp.node.right, temp.idx + 1, temp.depth + 1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = lv; i <= rv; i++){           
            List<Pair> temp = map.get(i);
            Collections.sort(temp);
            List<Integer> subans = new ArrayList<>();
            
            for(Pair x : temp){
                subans.add(x.node.val);
            }
            ans.add(subans);
        }
        
        return ans;
    }
}