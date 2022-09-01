class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length ; 
        boolean[][] vis = new boolean[n][m];
       
       for(int i = 0 ; i < n ; i++){
           for(int j = 0 ; j < m ; j++){
               if(vis[i][j] == false && matrix[i][j] == 0){
                   solve(matrix , i , j , vis);
               }
           }
       }
    }
    public void solve(int[][] matrix , int i , int j , boolean[][] vis){
       int row = i;
       int col = j;
        while(row >= 0){
           if(matrix[row][j] != 0){
               vis[row][j] = true;
               matrix[row][j] = 0;
           }
            row--;
        }
        row = i;
         while(row < matrix.length){
           if(matrix[row][j] != 0){
               vis[row][j] = true;
               matrix[row][j] = 0;
           }
             row++;
        }
         while(col >= 0){
           if(matrix[i][col] != 0){
               vis[i][col] = true;
               matrix[i][col] = 0;
           }
             col--;
        }
        col = j;
         while(col < matrix[0].length){
           if(matrix[i][col] != 0){
               vis[i][col] = true;
               matrix[i][col] = 0;
           }
             col++;
        }
        
    }
}