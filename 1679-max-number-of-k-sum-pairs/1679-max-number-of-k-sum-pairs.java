class Solution {
    public int maxOperations(int[] nums, int k) {
        int i = 0 , j = nums.length - 1 , count = 0;
        Arrays.sort(nums);
        while(i < j){
            int res = nums[i] + nums[j];
            if(res == k){
                count++;
                i++;
                j--;
            }
            else if(res < k) i++;
            else j--;
        }
        return count;
    }
}