class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return nums.length;
      int i = 1 , j = 1;
        while(j < nums.length){
          if(nums[j] == nums[j-1]){
              j++;
              continue;
          }
            else{
           nums[i] = nums[j];
            i++; j++;
        }
           
        }
        return i;
    }
}