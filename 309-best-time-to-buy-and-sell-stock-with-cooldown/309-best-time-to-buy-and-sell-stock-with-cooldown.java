class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 2][2];
        return memo(prices , 0 , 0);
    }
    public int memo(int[] prices , int idx , int flag){
        if(idx >= prices.length){
            return dp[idx][flag] = 0;
        }
        if(dp[idx][flag] != 0){
            return dp[idx][flag];
        }
        if(flag == 0){
            int buyhere = -prices[idx] + memo(prices , idx + 1 , 1);
            int notbuy = memo(prices , idx + 1 , 0);
            return dp[idx][flag] = Math.max(buyhere , notbuy);
        }else{
            int sellhere = prices[idx] + memo(prices , idx + 2 , 0);
            int notsell = memo(prices , idx + 1 , 1);
            return dp[idx][flag] = Math.max(sellhere , notsell);
        }
    }
}