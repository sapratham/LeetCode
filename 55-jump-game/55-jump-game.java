class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length - 1;
        int res = 0;
        for(int i = 0 ; i <= n ; i++){
            if(res < i) return false;
            res = Math.max(res , i + nums[i]);
        }
        return res >= n;
    }
}