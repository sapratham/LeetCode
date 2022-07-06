class Solution {
    public int search(int[] nums, int target) {
        int i = 0 , k = nums.length - 1;
        
        while(i <= k){
            int mid = (i+k)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[i]){
                if(target >= nums[i] && nums[mid] >= target){
                     k = mid - 1;
                }else{
                    i = mid + 1;
                }
            }else{
                if(target >= nums[mid] && target <= nums[k]){
                    i = mid + 1;
                }else{
                    k = mid - 1;
                }
            }
           
        }
        return -1;
    }
}