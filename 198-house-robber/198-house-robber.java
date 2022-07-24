class Solution {
    int[] dp ;
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);
        
        dp = new int[nums.length + 2];
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            if(i >= nums.length){
                continue;
            }
            if(dp[i] != 0){
                continue;
            }
            int rob = nums[i] + dp[i + 2];
            int notrob = dp[i + 1];
            
            dp[i] = Math.max(rob, notrob);
        }
        return dp[0];
        // return memo(nums , 0);
    }
//     public int memo(int[] num  , int idx){
//         if(idx >= num.length){
//             return 0;
//         }
//         if(dp[idx] != 0){
//             return dp[idx];
//         }
//         int rob = num[idx] + memo(num  , idx + 2);
//         int notrob = memo(num , idx + 1);
        
//         return dp[idx] = Math.max(rob,notrob);
//     }
}