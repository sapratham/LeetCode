class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];
        
        for(int i = 0 ; i < parent.length ; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        for(int[] e : edges){
            int x1 = find(e[0]);
            int y1 = find(e[1]);
            
            if(x1 != y1){
                union(x1,y1);
            }else{
                return e;
            }
        }
        return null;
    }
    int[] parent;
    int[] rank;
    
    void union(int x1 , int y1){
        if(rank[x1] < rank[y1]){
            parent[x1] = y1;
        }else if(rank[y1]  < rank[x1]) {
            parent[y1] = x1;
        }else{
            parent[x1] = y1;
            rank[y1]++;
        }
    }
     
    int find(int x){
        if(parent[x] == x){
            return x;
        }else{
            int pox = parent[x];
            int s1 = find(pox);
            parent[x] = s1;
            return s1;
        }
    }
}