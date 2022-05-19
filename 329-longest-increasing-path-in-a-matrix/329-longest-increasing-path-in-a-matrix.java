class Solution {
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length ;
        int m = matrix[0].length ;
        int[][] dp = new int[n][m];
        
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int count = findcount(matrix , i , j , dp);
                max = Math.max(count,max);
            }
        }
        return max;
    }
    public int findcount(int[][] matrix , int i , int j ,int[][] dp){
        
        if(dp[i][j] != 0) return dp[i][j];
        int max = 0;
        
        for(int k = 0 ; k < 4 ; k++){
            int nr = i + dir[k][0];
            int nc = j + dir[k][1];
            
            if(nr < 0 || nc < 0 || nr >= matrix.length || nc >= matrix[0].length || matrix[i][j] >= matrix[nr][nc]){
            continue;
            }
               max = Math.max( max , findcount(matrix , nr , nc , dp));
        }
        return dp[i][j] = max + 1;
    }
}