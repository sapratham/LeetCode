class Solution {
     class Pair{
        int i ;
        int j ;
        int val;
        Pair(int i , int j , int val){
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
    public int maxDistance(int[][] matrix) {
            boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        ArrayDeque<Pair> que = new ArrayDeque();
         int count = 0;
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 1){
                   que.add(new Pair(i , j , 0));
                }else{
                    count++;
                }
            }
        }
        if(count == 0) return -1;
        
        int dist = -1;
        
        while(que.size() > 0){
            Pair rem = que.remove();
            
            if(vis[rem.i][rem.j] == true){
                continue;
            }
            vis[rem.i][rem.j] = true;
            
            dist = Math.max(dist , rem.val);
            
            dir(rem.i + 1, rem.j , rem.val + 1, vis , que , matrix);
            dir(rem.i - 1, rem.j , rem.val + 1, vis , que , matrix);
            dir(rem.i , rem.j + 1, rem.val + 1, vis , que , matrix);
            dir(rem.i , rem.j - 1, rem.val + 1, vis , que , matrix);
        }
       return dist;
    }
       public void dir(int i , int j ,int val, boolean[][] vis , ArrayDeque<Pair> que, int[][] grid){
        if(i < 0 || j < 0 || i >= vis.length || j >= vis[0].length || vis[i][j] == true || grid[i][j] == 1){
            return;
        }
        que.add(new Pair(i , j , val));
    }
}