class Solution {
  
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
          if(obstacleGrid[0][0] == 1 || obstacleGrid[n-1][m-1] == 1) return 0;
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
       int path = Path(obstacleGrid , dp , 0 , 0);
        
        return path;
        
    }
    public int Path(int[][] obstacleGrid,int[][] dp , int i , int j){
        if(i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1){
           return 1;
        }
        if( i < 0 || j < 0 || i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1){
            return 0;
        }
  
        int res = 0;
        if(dp[i][j] != -1) return dp[i][j];
        
      int path =  Path(obstacleGrid, dp , i  , j +1);
      int path2 =   Path(obstacleGrid, dp  , i + 1 , j);
      
   
       res += path + path2;  
        return dp[i][j] = res;
        
    }
}