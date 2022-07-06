class Solution {
    int[] dp;
    public int fib(int n) {
        dp = new int[n+1];
        int res = rec(n);
        return res;
    }
    public int rec(int n){
        if(n <= 0){
            return dp[n] = 0;
        }
        
        if(n == 1 || n == 2) return dp[n] = 1;
        
        if(dp[n] != 0){
            return dp[n];
        }
        return dp[n] = rec(n - 1) + rec(n - 2);
        
    }
}