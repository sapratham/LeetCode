class Solution {
    public int[] sortArrayByParity(int[] nums) {
        if(nums.length == 1 || nums.length == 0) return nums;
        int start = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]%2 == 0){
                int temp = nums[start];
                nums[start] = nums[i];
                nums[i] = temp;
                start++;
            }
        }
        return nums;
    }
}