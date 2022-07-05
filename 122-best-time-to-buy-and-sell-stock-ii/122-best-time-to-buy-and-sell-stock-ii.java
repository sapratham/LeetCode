class Solution {
    
    public int maxProfit(int[] prices) {
    int[] prev = new int[2];
    for(int i = prices.length - 1 ; i >= 0 ; i--){
        int[] curr = new int[2];
        for(int flag = 0 ; flag < 2 ; flag++){
            if(i == prices.length){
                curr[flag] = 0;
                continue;
            }
            if(flag == 0){
                int buyhere = -prices[i] + prev[1];
                int notbuyhere = prev[0];
                curr[flag] = Math.max(buyhere , notbuyhere);
            }else{
                int sellhere = prices[i] + prev[0];
                int notsellhere = prev[1];
                curr[flag] = Math.max(sellhere , notsellhere);
            }   
        }
        prev = curr;
    }
        return prev[0];
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
