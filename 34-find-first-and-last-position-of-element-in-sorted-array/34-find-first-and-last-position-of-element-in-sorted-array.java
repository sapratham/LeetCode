class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0 , k = nums.length - 1;
        int j = -1;
        while(i <= k){
            int mid = (i+k)/2;
            if(nums[mid] == target){
                j = mid;
                break;
            }else if(nums[mid] > target){
                k = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        if(j == -1){
            return new int[]{-1,-1};
        }
        int[] res = new int[2];
        int start = j;
        int end = j;
        
        while( start > 0 && nums[start - 1] == target){
            start--;
        }
        while(end < nums.length - 1 && nums[end + 1] == target){
           end++;
        }
        res[0] = start;
        res[1] = end ;
        
        return res;
    }
}