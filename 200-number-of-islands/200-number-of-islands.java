class Solution {
    
    public int numIslands(char[][] grid) {
        int n = grid.length ;
        int m = grid[0].length ; 
        int count = 0 ;
        boolean[][] vis = new boolean[n][m];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(vis[i][j] == false && grid[i][j] == '1'){
                    count++;
                    traverse(grid , vis , i , j);
                }
            }
        }
        return count;
    }
    public void traverse(char[][] grid , boolean[][] vis , int i , int j){
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] == true || grid[i][j] == '0'){
            return;
        }
        
        vis[i][j] = true;
        traverse(grid , vis , i  , j + 1);
        traverse(grid , vis , i + 1 , j);
        traverse(grid , vis , i  , j - 1);
        traverse(grid , vis , i - 1 , j);
    }
}