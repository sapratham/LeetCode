class Solution {
  //  int[][] dp;
    public int maxProfit(int[] prices, int fee) {
            int[] prev = new int[2];
    for(int i = prices.length - 1 ; i >= 0 ; i--){
        int[] curr = new int[2];
        for(int flag = 0 ; flag < 2 ; flag++){
            if(i == prices.length){
                curr[flag] = 0;
                continue;
            }
            if(flag == 0){
                int buyhere = -prices[i] + prev[1] ;
                int notbuyhere = prev[0];
                curr[flag] = Math.max(buyhere , notbuyhere);
            }else{
                int sellhere = prices[i] + prev[0] - fee;
                int notsellhere = prev[1];
                curr[flag] = Math.max(sellhere , notsellhere);
            }   
        }
        prev = curr;
    }
        return prev[0];
    }
//     public int memo(int[] prices, int fee , int idx , int flag){
//         if(idx == prices.length){
//             return dp[idx][flag] = 0;
//         }
        
//         if(dp[idx][flag] != 0){
//             return dp[idx][flag];
//         }
//         if(flag == 0){
//          int buyhere = -prices[idx] + memo(prices ,fee , idx + 1 , 1);
//          int notbuy = memo(prices ,fee , idx + 1 , 0);
//             return dp[idx][flag] = Math.max(buyhere , notbuy);
//         }else{
//             int sellhere = prices[idx] + memo(prices ,fee , idx + 1 , 0) - fee;
//             int notsell = memo(prices ,fee ,idx + 1 , 1);
//             return dp[idx][flag] = Math.max(sellhere , notsell);
//         }
//     }
}