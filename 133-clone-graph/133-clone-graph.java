/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Node[] arr = new Node[101];
        return helper( node , arr);
        
    }
    public Node helper(Node node , Node[] vis){
            Node clone = new Node(node.val);
            vis[node.val] = clone;
            
           for(Node nbr : node.neighbors){
               if(vis[nbr.val] == null){
                   Node nbrclone = helper(nbr , vis);
                   clone.neighbors.add(nbrclone);
               }else{
                   Node nbrclone = vis[nbr.val];
                   clone.neighbors.add(nbrclone);
               }
           }
        return clone;
    }
}