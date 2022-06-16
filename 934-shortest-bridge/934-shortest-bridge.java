class Solution {
    class Pair{
        int i ;
        int j ;
        int level;
        Pair(int i , int j , int level){
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        ArrayDeque<Pair> que = new ArrayDeque();
        boolean[][] vis1 = new boolean[n][m];
        boolean found = false;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    que.add(new Pair(i , j , 0));
                    dfs(grid, que , vis1 , i , j);
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }
        
        boolean[][] vis2 = new boolean[n][m];
        while(que.size() > 0){
            Pair rem = que.remove();
            
            if(vis2[rem.i][rem.j]){
                continue;
            }
            vis2[rem.i][rem.j] = true;
            
            if(grid[rem.i][rem.j] == 1 && vis1[rem.i][rem.j] == false){
                return rem.level - 1;
            }
             
            addN(grid, que , vis2, vis1 , rem.i - 1, rem.j , rem.level + 1);
            addN(grid, que , vis2, vis1 , rem.i + 1, rem.j , rem.level + 1);
            addN(grid, que , vis2, vis1 , rem.i , rem.j - 1, rem.level + 1);
            addN(grid, que , vis2, vis1 , rem.i , rem.j + 1, rem.level + 1);
        }
        return -1;
    }
    public void dfs(int[][] grid , ArrayDeque<Pair> que , boolean[][] vis1 , int i , int j){
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || vis1[i][j] == true){
            return;
        }
        vis1[i][j] = true;
        que.add(new Pair(i , j , 0));
        
        dfs(grid , que , vis1 , i - 1 , j);
        dfs(grid , que , vis1 , i + 1 , j);
        dfs(grid , que , vis1 , i , j - 1);
        dfs(grid , que , vis1 , i , j + 1);
    }
    public void addN(int[][] grid , ArrayDeque<Pair> que , boolean[][] vis2 , boolean[][] vis1 , int i , int j , int level){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis1[i][j] == true || vis2[i][j] == true){
            return;
        }
        que.add(new Pair(i , j , level));
    }
}