class Solution {
  public int maxProfit(int[] prices) {
    
    int n = prices.length;
    int[] maxProfit = new int[n];
    int[] maxLoss = new int[n];
    
    int profit = 0;
    int buy = Integer.MAX_VALUE;
    
    for(int i = 0; i < n; i++){
        profit = Math.max(profit, prices[i] - buy);
        maxProfit[i] = profit;
        buy = Math.min(buy, prices[i]);
    }
    
    int loss = 0;
    int buy2 = 0;
    
    for(int i = n-1; i >= 0; i--){
        loss = Math.max(loss, buy2 - prices[i]);
        maxLoss[i] = loss;
        buy2 = Math.max(buy2, prices[i]);
    }
    
    int ans = 0;
    for(int i = 0; i < n; i++){
        ans = Math.max(ans, maxProfit[i] + maxLoss[i]);
    }
    return ans;
}
}
    //  public int memo(int[] prices , int flag , int idx , int trans){
    //     if(idx == prices.length || trans == 0){
    //         return dp[idx][flag][trans] = 0;
    //     }
    //     if(dp[idx][flag][trans] != 0){
    //         return dp[idx][flag][trans];
    //     }
    //     if(flag == 0){
    //         int buyhere = -prices[idx] + memo(prices , 1 , idx + 1 , trans);
    //         int notbuy = memo(prices , 0 , idx + 1 , trans);
    //         return dp[idx][flag][trans] = Math.max(buyhere , notbuy);
    //     }else{
    //         int sellhere = prices[idx] + memo(prices , 0 , idx + 1 , trans - 1);
    //         int notsell = memo(prices , 1 , idx + 1 , trans);
    //         return dp[idx][flag][trans] = Math.max(sellhere , notsell);
    //     }
    // }
