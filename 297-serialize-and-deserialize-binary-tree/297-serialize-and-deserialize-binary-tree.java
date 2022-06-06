/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
   
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
         StringBuilder str = new StringBuilder();
        helper(root , str);
        
       return str.toString();
    }
    public void helper(TreeNode root , StringBuilder str){
       if(root == null){
            str.append(".");
            str.append(" ");
           return;
        }
        str.append(root.val);
        str.append(" ");
        
        helper(root.left , str);
        helper(root.right , str); 
    }
    class Pair{
        TreeNode node;
        int state;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        String[] darray = data.split(" ");
        Stack<Pair> stk = new Stack<>();
        int idx = 0;
        Pair rootp = new Pair();
        rootp.node  = new TreeNode(Integer.parseInt(darray[0]));
        stk.add(rootp);
        while(stk.size() > 0){
            Pair pair = stk.peek();
            if(pair.state == 0){
                idx++;
                pair.state++;
                
                if(darray[idx].equals(".") == false){
                    Pair leftp = new Pair();
                    leftp.node = new TreeNode(Integer.parseInt(darray[idx]));
                    pair.node.left = leftp.node;
                    
                    stk.push(leftp);
                }
            }else if(pair.state == 1){
                idx++;
                pair.state++;
                
                if(darray[idx].equals(".") == false){
                    Pair rightp = new Pair();
                    rightp.node = new TreeNode(Integer.parseInt(darray[idx]));
                    pair.node.right = rightp.node;
                    
                    stk.push(rightp);
                }
            }else{
                stk.pop();
            }
        }
        return rootp.node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));