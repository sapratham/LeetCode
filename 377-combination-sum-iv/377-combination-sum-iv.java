class Solution {
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
      dp = new int[target + 1];
      Arrays.fill(dp , -1);
      return solve(nums , target , 0);
    }
    public int solve(int[] nums ,int target , int sum){
        if(sum == target){
            return 1;
        }
        if(sum > target){
            return 0;
        }
        if(dp[sum] != -1){
            return dp[sum];
        }
        int ans = 0;
        for(int i = 0 ; i < nums.length ; i++){
           ans += solve(nums , target , sum + nums[i]) ;
        }
        
        return dp[sum] = ans;
    }
}