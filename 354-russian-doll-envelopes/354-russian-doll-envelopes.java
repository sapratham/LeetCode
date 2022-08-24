class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes , (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = envelopes.length ;
        int[] dp = new int[n];
        int ans = 0;
        
        // for(int i = 0 ; i < n ; i++){
        //     int max = 0 ;
        //     for(int j = 0 ; j < i ; j++){
        //        if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
        //            max = Math.max(max , dp[j]);
        //        } 
        //     }
        //     dp[i] = max + 1;
        //     ans = Math.max(dp[i] , ans);
        // } // tle 85/87 cases passed
        
         for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, ans, envelope[1]);
            if(index < 0)
                index = -(index + 1);
            dp[index] = envelope[1];
            if(index == ans)
            ans++;
        }
        
        return ans;
    }
}