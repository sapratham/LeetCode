class Solution {
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        dp = new int[prices.length + 1][2][k + 1];
        return memo(prices , 0 , 0 , k);
    }
       public int memo(int[] prices , int flag , int idx , int trans){
        if(idx == prices.length || trans == 0){
            return dp[idx][flag][trans] = 0;
        }
        if(dp[idx][flag][trans] != 0){
            return dp[idx][flag][trans];
        }
        if(flag == 0){
            int buyhere = -prices[idx] + memo(prices , 1 , idx + 1 , trans);
            int notbuy = memo(prices , 0 , idx + 1 , trans);
            return dp[idx][flag][trans] = Math.max(buyhere , notbuy);
        }else{
            int sellhere = prices[idx] + memo(prices , 0 , idx + 1 , trans - 1);
            int notsell = memo(prices , 1 , idx + 1 , trans);
            return dp[idx][flag][trans] = Math.max(sellhere , notsell);
        }
    }

}