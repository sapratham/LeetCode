class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int mintill = prices[0];
        for(int i = 1; i < prices.length ; i++){
            if(mintill > prices[i]){
                mintill = prices[i];
            }
            int profit = prices[i] - mintill;
            max = Math.max(max , profit);
        }
        return max;
    }
}