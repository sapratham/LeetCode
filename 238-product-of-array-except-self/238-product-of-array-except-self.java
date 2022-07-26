class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul = 1 , mul2 = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                mul2++;
            }else{
            mul *= nums[i];
            }
        }
        if(mul2 > 0){
            if(mul2 > 1){
             Arrays.fill(nums , 0);
                return nums;
            }
            for(int i = 0 ; i < nums.length ; i++){
                if(nums[i] != 0){
                    nums[i] = 0;
                }else{
                    nums[i] = mul;
                }
            }
        }else{
            for(int i = 0 ; i < nums.length ; i++){
                nums[i] = mul / nums[i];
            }
        }
        return nums;
    }
}