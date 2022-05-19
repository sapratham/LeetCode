/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    ArrayList<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
      if(root == null) return new ArrayList();
        Post(root);
        return res;
    }
    public void Post(Node root){
        if(root == null) return;
        
        for(Node node : root.children){
            Post(node);
        }
        
        res.add(root.val);
    }
}