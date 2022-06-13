class Solution {
    boolean flag = true;
    int len = 0;
    public int numEnclaves(int[][] grid) {
          int n = grid.length ;
        int m = grid[0].length ; 
        
        int count = 0 ;
        boolean[][] vis = new boolean[n][m];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(vis[i][j] == false && grid[i][j] == 1){
                    flag = true;
                    len = 0;
                    traverse(grid , vis , i , j );
                    if(flag == true){
                        count += len;
                    }
                }
            }
        }
        return count;
    }
      public void traverse(int[][] grid , boolean[][] vis , int i , int j ){
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            flag = false;
            return;
        }else if(grid[i][j] == 0){
            return;
        }else if(vis[i][j] == true){
            return;
        }
       
        vis[i][j] = true;
          
        len++;
          
        traverse(grid , vis , i - 1 , j  );
        traverse(grid , vis , i + 1 , j );
        traverse(grid , vis , i  , j - 1 );
        traverse(grid , vis , i , j + 1 );
    }
}