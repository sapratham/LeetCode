class Solution {
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length + 1][2];
        return memo(prices , fee , 0 , 0);
    }
    public int memo(int[] prices, int fee , int idx , int flag){
        if(idx == prices.length){
            return dp[idx][flag] = 0;
        }
        
        if(dp[idx][flag] != 0){
            return dp[idx][flag];
        }
        if(flag == 0){
         int buyhere = -prices[idx] + memo(prices ,fee , idx + 1 , 1);
         int notbuy = memo(prices ,fee , idx + 1 , 0);
            return dp[idx][flag] = Math.max(buyhere , notbuy);
        }else{
            int sellhere = prices[idx] + memo(prices ,fee , idx + 1 , 0) - fee;
            int notsell = memo(prices ,fee ,idx + 1 , 1);
            return dp[idx][flag] = Math.max(sellhere , notsell);
        }
    }
}