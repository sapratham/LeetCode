class Solution {
    
    public int maxProfit(int[] prices) {
    int[][] dp = new int[prices.length + 1][2];
    for(int i = prices.length - 1 ; i >= 0 ; i--){
        for(int flag = 0 ; flag < 2 ; flag++){
            if(i == prices.length){
                dp[i][flag] = 0;
                continue;
            }
            if(flag == 0){
                int buyhere = -prices[i] + dp[i+1][1];
                int notbuyhere = dp[i+1][0];
                dp[i][flag] = Math.max(buyhere , notbuyhere);
            }else{
                int sellhere = prices[i] + dp[i+1][0];
                int notsellhere = dp[i+1][1];
                dp[i][flag] = Math.max(sellhere , notsellhere);
            }
        }
    }
        return dp[0][0];
    }
}
    // public int rec(int idx , int flag , int[] prices){ // memoization
    //     if(idx == prices.length){
    //      return dp[idx][flag] = 0;
    //     }
    //     if(dp[idx][flag] != 0){
    //         return dp[idx][flag];
    //     }
    //      // flag = 0 -> buy , flag = 1 -> sell;
    //     if(flag == 0){
    //        int buyhere = -prices[idx] + rec(idx + 1 , 1 , prices);
    //        int notbuyhere = rec(idx + 1 , 0 , prices);
    //         return dp[idx][flag] = Math.max(buyhere , notbuyhere);
    //     }else{
    //         int sellhere = prices[idx] + rec(idx + 1 , 0 , prices);
    //         int notsellhere = rec(idx + 1 , 1 , prices);
    //         return dp[idx][flag] = Math.max(sellhere , notsellhere);
    //     }
    // }
