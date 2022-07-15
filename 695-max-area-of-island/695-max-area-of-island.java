class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(vis[i][j] == false && grid[i][j] == 1){
                    count = Math.max(count , solve(grid , vis , i , j));
                }
            }
        }
        return count;
    }
    public int solve(int[][] grid , boolean[][] vis , int i , int j ){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] == true || grid[i][j] == 0){
            return 0;
        }
        vis[i][j] = true;
        int ri = solve(grid , vis , i + 1 , j);
        int dw = solve(grid , vis , i  , j + 1);
        int le = solve(grid , vis , i - 1 , j);
        int up = solve(grid , vis , i  , j - 1);
        
        return ri + dw + le + up + 1;
    }
}