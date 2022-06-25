class Solution {
    public boolean checkPossibility(int[] nums) {
        int mod = 0 ;
        for(int i = 1; i < nums.length ; i++){
            if(nums[i-1] > nums[i]){
                if(mod > 0) return false;
                mod++;
                if(i < 2 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];
                else{
                    nums[i] = nums[i-1];
                }
            }
            
        }
        return true;
    }
}