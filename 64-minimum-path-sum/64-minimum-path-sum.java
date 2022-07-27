class Solution {
    int[][] memo;
    public int minPathSum(int[][] grid) {
        memo = new int[grid.length + 1][grid[0].length + 1];
        return solve(0 , 0 , grid );
    }
    public int solve(int i , int j , int[][] grid ){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ){
            return Integer.MAX_VALUE;
        }
        if(i == grid.length - 1 && j == grid[0].length - 1){
          return grid[i][j];
        }
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        int right = solve(i , j + 1 , grid );
        int down =  solve(i + 1 , j , grid );
        
        return memo[i][j] = grid[i][j] + Math.min(right , down);
    }
}