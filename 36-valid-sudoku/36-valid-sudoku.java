class Solution {
    public boolean isValidSudoku(char[][] board) {
        
  
        // check grid
        for(int i = 0 ; i < 9 ; i += 3){
            for(int j = 0 ; j < 9 ; j += 3){
                boolean[] vis = new boolean[10];
                for(int k = 0 ; k < 9 ; k++){
                    char ch = board[i + k/3][j + k%3];
                    if(ch != '.'){
                        if(vis[ch - '0'] == true){
                            return false;
                        }
                        vis[ch - '0'] = true;
                    }
                }
            }
        }
        return checkrow(board) && checkcol(board);
    }
    public boolean checkrow(char[][] board){
         for(int i = 0 ; i < 9 ; i++){
            boolean[] vis = new boolean[10];
            for(int j = 0 ; j < 9 ; j++){
                char ch = board[i][j];
                if(ch != '.'){
                if(vis[ch - '0'] == true){
                    return false;
                }
                vis[ch - '0'] = true;
                }
            }
        }
        return true;
    }
     public boolean checkcol(char[][] board){
         for(int i = 0 ; i < 9 ; i++){
            boolean[] vis = new boolean[10];
            for(int j = 0 ; j < 9 ; j++){
                char ch = board[j][i];
                if(ch != '.'){
                if(vis[ch - '0'] == true){
                    return false;
                }
                vis[ch - '0'] = true;
                }
            }
        }
        return true;
    }
}