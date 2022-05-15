class Solution {
    class Pair{
        int i ;
        int j ;
        Pair(int i , int j){
            
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid) {
        
        int[][] dir = {{-1,0} , {1,0} , {0,1} , {0,-1}};
        int time = 0;
        Queue<Pair> que = new ArrayDeque<>();
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 2){
                    que.add(new Pair( i , j));
                }
            }
        }
        while(que.size() != 0){
            int size = que.size();
            while(size-- > 0){
                Pair rem = que.remove();
                for(int i =  0; i<4 ; i++){
                    int row = rem.i + dir[i][0];
                    int col = rem.j + dir[i][1];
                    
                    if(row >= 0 && col >= 0 && col < grid[0].length && row < grid.length && grid[row][col] == 1){
                        grid[row][col] = 2;
                        que.add(new Pair(row , col));
                    }
                }
            }
            time++;
        }
          for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return (time - 1 < 0)? 0 : time - 1;
    }
}