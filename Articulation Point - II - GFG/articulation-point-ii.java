// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int[] ans = obj.articulationPoints(V, adj);
            for(int i: ans)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    public int[] articulationPoints(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean[] vis = new boolean[V];
        int[] dis = new int[V];
        int[] low = new int[V];
        boolean[] aps = new boolean[V];
        
        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                dfs(adj ,vis, dis , low , aps , i , -1);
            }
        }
        int count = 0;
        for(boolean i : aps){
            if(i == true){
               count++; 
            }
        }
        if(count == 0){
            return new int[]{-1};
        }else{
            int[] res = new int[count];
            int idx = 0;
            for(int i = 0 ; i < aps.length ; i++){
                if(aps[i]){
                    res[idx++] = i;
                } 
            }
            return res;
        }
       
    }
    int time = 0;
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis , int[] dis ,int[] low , boolean[] aps , int u , int p ){
        vis[u] = true;
        dis[u] = low[u] = ++time;
         
         int c = 0 ;
         
        for(int v : adj.get(u)){
            if(v == p){
                continue;
            }else if(vis[v]){
                low[u] = Math.min(low[u],dis[v]);
            }else{
               c++;
               dfs(adj ,vis, dis , low , aps , v, u);
                low[u] = Math.min(low[u] , low[v]);
                
                if(p != -1 && low[v] >= dis[u]){
                    aps[u] = true;
                }
            }
            
        }
        if(p == -1 && c > 1){
            aps[u] = true;
        }
    }
}