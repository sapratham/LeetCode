// { Driver Code Starts
//Initial Template for Java


//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}



class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Solution ob = new Solution();
			    ArrayList <Integer> res = ob.bottomView(root);
			    for (Integer num : res) System.out.print (num + " ");
		     	System.out.println();
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
         
        if(root == null) return new ArrayList<>();
        // add your code
        Pair p = new Pair();
        p.node = root;
        p.val = 0;
        HashMap<Integer,Node> hmap = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int left = 0 , right = 0;
        Queue<Pair> que = new ArrayDeque<>();
        que.add(p);
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                Pair rem = que.remove();
                
                 if(rem.val < left) left = rem.val;
                 
                  if(rem.val > right) right = rem.val;
                
                
                    hmap.put(rem.val , rem.node);
                
                
                if(rem.node.left != null){
                   Pair lp = new Pair();
                   lp.node = rem.node.left;
                   lp.val = rem.val - 1;
                   que.add(lp);
                   
                }
                if(rem.node.right != null){
                    Pair rp = new Pair();
                    rp.node = rem.node.right;
                    rp.val = rem.val + 1;
                   que.add(rp);
                }
            }
        }
        for(int i = left ; i <= right ; i++){
            arr.add(hmap.get(i).data);
        }
       return arr; 
    }
    static class Pair{
        Node node ; 
        int val ;
       
    }
    
}