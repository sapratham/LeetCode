class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length + 1];
       return Math.min(solve(0,cost) , solve(1 , cost)); 
    }
    public int solve(int idx , int[] cost){
        if(idx >= cost.length){
            return 0;
        }
        if(dp[idx] != 0){
            return dp[idx];
        }
        
       int for1 = solve(idx + 1 , cost);
       int for2 = solve(idx + 2 , cost);

        return dp[idx] = Math.min(for1 , for2) + cost[idx];
    }
}