class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix.length == 1 || matrix[0].length == 1) return true;
        int row = 0;
        int col = 1;
        
        while(row < matrix.length){
            int i = row , j = 0;
            int a = matrix[i][j];
            while(i < matrix.length && j < matrix[0].length){
                if( a != matrix[i][j]) return false;
                i = i + 1 ;
                j = j + 1 ;
            }
            row++;
        }
          while(col < matrix[0].length){
            int i = 0 , j = col;
            int a = matrix[i][j];
            while(i < matrix.length && j < matrix[0].length){
                if( a != matrix[i][j]) return false;
                i = i + 1 ;
                j = j + 1 ;
            }
            col++;
        }
        return true;
    }
}