class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length ; 
          for (int i=0;i<len-1;++i){

            for(int j=0;j<len-i-1; ++j){

                if(nums[j+1]<nums[j]){

                    int swap = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = swap;

                }
            }
        }
    }
}