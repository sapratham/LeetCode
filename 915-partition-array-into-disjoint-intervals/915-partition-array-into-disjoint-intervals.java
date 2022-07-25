class Solution {
    public int partitionDisjoint(int[] nums) {
        int left = 0 , max = nums[0] , lmax = nums[0];
        for(int i = 1 ; i < nums.length ; i++ ){
            if(max < nums[i]){
                max = nums[i];
            }else if(lmax > nums[i]){
               lmax = max;
                left = i ;
            } 
        }
        return left + 1;
    }
}