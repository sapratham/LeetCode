class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int Klargest = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 0 ; i--){
            if(k == 1){
                return nums[i];
            }else{
              k--;
            }
        }
        return 0;
    }
}