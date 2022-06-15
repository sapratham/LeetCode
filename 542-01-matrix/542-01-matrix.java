class Solution {
    class Pair{
        int i ;
        int j ;
        int val;
        Pair(int i , int j , int val){
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
    
    public int[][] updateMatrix(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        ArrayDeque<Pair> que = new ArrayDeque();
        
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                   que.add(new Pair(i , j , 0));
                }
            }
        }
        
        while(que.size() > 0){
            Pair rem = que.remove();
            
            if(vis[rem.i][rem.j] == true){
                continue;
            }
            vis[rem.i][rem.j] = true;
            
            ans[rem.i][rem.j] = rem.val;
            
            dir(rem.i + 1, rem.j , rem.val + 1, vis , que);
            dir(rem.i - 1, rem.j , rem.val + 1, vis , que);
            dir(rem.i , rem.j + 1, rem.val + 1, vis , que);
            dir(rem.i , rem.j - 1, rem.val + 1, vis , que);
        }
        
        return ans;
    }
    
    public void dir(int i , int j ,int val, boolean[][] vis , ArrayDeque<Pair> que){
        if(i < 0 || j < 0 || i >= vis.length || j >= vis[0].length || vis[i][j] == true){
            return;
        }
        que.add(new Pair(i , j , val));
    }
    
}