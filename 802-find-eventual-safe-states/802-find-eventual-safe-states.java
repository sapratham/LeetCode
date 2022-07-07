class Solution {
    int[] vis;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Integer> res = new ArrayList<>();
        vis = new int[graph.length];
        for(int i = 0 ; i < graph.length ; i++){
            
              if(dfs(i , graph)){
                  res.add(i);
              }
            
        }
        return res;
    }
    public boolean dfs(int v , int[][] graph){
        if(vis[v] == 2){
            return true;
        }else if(vis[v] == 1){
            return false;
        }else{
            vis[v] = 1;
            for(int n : graph[v]){
                boolean isnbrSafe = dfs(n , graph);
                if(isnbrSafe == false){
                    return false;
                }
            }
            vis[v] = 2;
            return true;
        }
    }
}