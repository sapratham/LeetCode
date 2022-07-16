class Solution {
    int[][][] dp;
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k <= maxMove; k++)
                    dp[i][j][k] = -1;
        return solve(m, n, maxMove, startRow, startColumn , 0) % mod;
    }
    public int solve(int m, int n, int move, int r, int c , int count) {
        if (r < 0 || c < 0 || r >= m || c >= n)
            return 1;
        if (move <= 0)
            return 0;
        if (dp[r][c][move] != -1)
            return dp[r][c][move] % mod;
        int ri = solve(m , n , move - 1 , r + 1, c , count) % mod;
        int dw = solve(m , n , move - 1 , r , c + 1 , count) % mod;
        int le = solve(m , n , move - 1 , r - 1, c , count) % mod;
        int up = solve(m , n , move - 1 , r , c - 1 , count) % mod;
        dp[r][c][move] = ((ri + dw)% mod + (le + up)% mod)% mod;
        return dp[r][c][move] % mod;
    }
}