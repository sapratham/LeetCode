class Solution {
    public int search(int[] nums, int target) {
        int left = 0 , right = nums.length - 1; 
       
        if(nums.length == 0) return -1;
        while(left <= right){
             int mid =( left + right ) / 2;
            if(nums[mid] == target) return mid;
            if(target > nums[left]){
                left++;
            }
            if(target < nums[right]){
                right--;
            }
        }
        return -1;
    }
}