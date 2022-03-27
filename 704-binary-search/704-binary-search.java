class Solution {
    public int search(int[] nums, int target) {
        int left = 0 , right = nums.length - 1; 
       
        if(nums.length == 0) return -1;
        while(left <= right){
             int mid =( left + right ) / 2;
            if(nums[mid] == target) return mid;
            if(target > nums[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
}