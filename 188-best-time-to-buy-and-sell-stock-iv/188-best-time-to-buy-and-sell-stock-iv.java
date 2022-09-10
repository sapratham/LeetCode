class Solution {
    int[][][] memo;

    public int maxProfit(int k, int[] prices) {
        memo = new int[prices.length + 1][2][k + 1];
        
        return memoization(prices, 0, 0, k);
    }

    public int memoization(int[] prices, int i, int flag, int k) {
        if (i == prices.length || k == 0) {
            return 0;
        }
        if (memo[i][flag][k] != 0) {
            return memo[i][flag][k];
        }
        if (flag == 0) {
            int buyhere = -prices[i] + memoization(prices, i + 1, 1, k);
            int notbuy = memoization(prices, i + 1, 0, k);
            return memo[i][flag][k] = Math.max(buyhere, notbuy);
        } else {
            int sellhere = prices[i] + memoization(prices, i + 1, 0, k - 1);
            int notsell = memoization(prices, i + 1, 1, k);
            return memo[i][flag][k] = Math.max(sellhere, notsell);
        }
    }
}
