class Solution {
    
    public List<String> generateParenthesis(int n) {
          List<String> res = new ArrayList();
         recursion( "(" , 1 , 0 , n , res);
         return res;
    }
    public void recursion( String str , int open , int close , int n , List<String> res){
        if(str.length() == 2*n){
            res.add(str);
            return;
        }
       if(open < n){
           recursion(str + "(" , open + 1 , close , n , res);
       }
        if(close < open){
            recursion(str + ")" , open , close + 1 , n , res);
        }
       
    }
}