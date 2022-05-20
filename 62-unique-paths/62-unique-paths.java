class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        int path = Path(dp , 0 , 0 , m , n);
        return path;
    }
     public int Path(int[][] dp , int i , int j , int m ,int n){
        if(i == m - 1 && j == n - 1){
           return 1;
        }
        if( i < 0 || j < 0 || i >= m || j >= n ){
            return 0;
        }
  
        int res = 0;
        if(dp[i][j] != -1) return dp[i][j];
        
      int path =  Path( dp , i  , j +1 , m , n);
      int path2 =   Path( dp  , i + 1 , j ,m ,n);
      
   
       res += path + path2;  
        return dp[i][j] = res;
        
    }
}
