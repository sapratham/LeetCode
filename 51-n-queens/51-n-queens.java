class Solution {
   List<List<String>> answer;
public List<List<String>> solveNQueens(int n) {
    
    answer = new ArrayList<>();
    
    // create a n*n chessboard
    char[][] board = new char[n][n];
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            board[i][j] = '.';
        }
    }
    
    placeNQueens(board, 0, n); // 0 is row number(we will fill rowwise)
    
    return answer;
}

private void placeNQueens(char[][] board, int row, int n){
    
    // base case
    if(row == n){
        List<String> ans = generateList(board);
        answer.add(ans);
        return;
    }
    
    // check for all columns
        // check if its safe to place queen
            // if its safe -> then place the queen and move to next row
    for(int col = 0; col < n ; col++){
        if (isSafe(board, row, col, n)){
            board[row][col] = 'Q';
            placeNQueens(board, row+1, n);
            board[row][col] = '.'; // remove queen while backtracking
        }
    }
}

private List<String> generateList(char[][] board){
    
    List<String> list = new ArrayList<>();
    for(char[] arr : board){
        list.add(String.valueOf(arr));
    }
    return list;
}

private boolean isSafe(char[][] board, int row, int col, int n){

    // check column on upper side
    for (int i = row; i >= 0; i--){
        if (board[i][col] == 'Q'){
            return false;
        }
    }
    // check upper diagonal on left side
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--){
        if (board[i][j] == 'Q'){
            return false;
        }
    }
    // check upper diagonal on right side
    for (int i = row, j = col; i >= 0 && j < n; i--, j++){
        if (board[i][j] == 'Q'){
            return false;
        }
    }
    return true;
}
}