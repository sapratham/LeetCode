class Solution {
    public int minMoves2(int[] nums) {
        if(nums.length == 1) return 0;
        int count = 0;
        Arrays.sort(nums);
        int i = 0 , k = nums.length - 1;
        int mid = (i+k)/2;
        while(i <= k){
            if(nums[i] == nums[mid]){
                i++;
            }else if(nums[i] < nums[mid]){
                count += nums[mid] - nums[i];
                nums[i] = nums[mid];
            }
            if(nums[k] == nums[mid]){
                k--;
            }else if(nums[k] > nums[mid]){
                count += nums[k] - nums[mid];
                nums[k] = nums[mid];
                
            }
        }
        return count;
    }
}