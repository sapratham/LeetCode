class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        
        for(int i = nums.length - 1 ; i >= 2 ; i--){
            int j = i - 1;
            int k = i - 2;
            
            if(nums[j] + nums[k] > nums[i]){
                return nums[i] + nums[j] + nums[k];
            }
        }
        return 0;
    }
}