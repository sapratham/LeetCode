class Solution {
    class Pair{
        int i ; 
        int j ;
        boolean border;
        Pair(int i , int j ){
            this.i = i;
            this.j = j;
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        ArrayList<Pair> res = new ArrayList();
        ArrayDeque<Pair> que = new ArrayDeque();
        
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        
        Pair p = new Pair(row , col);
        p.border = isBorder(row , col , grid);
        
        que.add(p);
        int orgc = grid[row][col];
        
        while(que.size() > 0){
            Pair rem = que.remove();
            
            if(vis[rem.i][rem.j] == true){
                continue;
            }
            vis[rem.i][rem.j] = true;
            
            if(rem.border){
                res.add(rem);
            }
            
            addN(grid, vis , que , orgc , rem.i - 1 , rem.j);
            addN(grid, vis , que , orgc , rem.i + 1 , rem.j);
            addN(grid, vis , que , orgc , rem.i , rem.j - 1);
            addN(grid, vis , que , orgc , rem.i , rem.j + 1);
        }
        for(Pair pa : res){
            grid[pa.i][pa.j] = color;
        }
        return grid;
    }
    
    public void addN(int[][] grid , boolean[][] vis , ArrayDeque<Pair> que , int color , int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != color || vis[i][j] == true){
            return;
        }
        Pair p = new Pair(i , j);
        p.border = isBorder(i , j , grid);
        que.add(p);
    }
    public boolean isBorder(int i , int j , int[][] grid){
       if( i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1){
           return true;
       } else{
           int color = grid[i][j];
           if(grid[i - 1][j] != color || grid[i + 1][j] != color || grid[i][j - 1] != color || grid[i][j + 1] != color){
               return true;
           }else{
               return false;
           }
       }
    }
}