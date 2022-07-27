class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int mul = 1;
        
        for(int i = 0 ; i < nums.length ; i++){
            mul *= nums[i];
            res = Math.max(mul , res);
            
            if(nums[i] == 0){
                mul = 1;
            }
        }
        mul = 1;
        for(int i = nums.length - 1 ; i >= 0 ; i--){
              mul *= nums[i];
            res = Math.max(mul , res);
            
            if(nums[i] == 0){
                mul = 1;
            }
        }
        
        return res;
    }
}