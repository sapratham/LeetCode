class Solution {
    public boolean equationsPossible(String[] equations) {
       rank = new int[26];
       parent = new int[26];
        
        for(int i = 0 ; i < 26 ; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        for(String eq : equations){
            if(eq.charAt(1) == '='){
                int ch1 = eq.charAt(0) - 'a';
                int ch2 = eq.charAt(3) - 'a';
                
                int f1 = find(ch1);
                int f2 = find(ch2);
                
                if(f1 != f2){
                    union(f1,f2);
                }
            }
        }
        for(String eq : equations){
            if(eq.charAt(1) == '!'){
                int ch1 = eq.charAt(0) - 'a';
                int ch2 = eq.charAt(3) - 'a';
                
                int f1 = find(ch1);
                int f2 = find(ch2);
                
                if(f1 == f2){
                    return false;
                }
            }
        }
        return true;
    }
    int[] rank;
    int[] parent;
    
    void union(int i , int j){
        if(rank[i] < rank[j]){
            parent[i] = j;
        }else if(rank[j] < rank[i]){
            parent[j] = i;
        }else{
            parent[i] = j;
            rank[j]++;
        }
    }
    int find(int x){
        if(parent[x] == x){
            return parent[x];
        }else{
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}