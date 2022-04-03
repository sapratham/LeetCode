class Solution {
    public void reverse(int[] nums , int low){
        int left = low;
        int right = nums.length - 1;
        while(left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
    public void swap(int[] nums ,int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int left = nums.length - 2;
        while(left >= 0 && nums[left] >= nums[left+1]) left--;
        if(left >= 0){
            int right = nums.length - 1;
            while(right >= 0 && nums[left] >= nums[right]) right--;
            swap(nums,left,right);
        }
        reverse(nums,left + 1);
    }
}