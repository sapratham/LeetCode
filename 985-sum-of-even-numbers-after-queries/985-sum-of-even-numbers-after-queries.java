class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
      
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
           
            if(nums[i] % 2 == 0){
                sum += nums[i];
            }
        }
        int[] res = new int[nums.length];
        int j = 0;
         for(int[] arr : queries){
             int val = arr[0];
             int idx = arr[1];
             
             if(nums[idx] % 2 != 0 && (nums[idx] + val)%2 == 0){
                 
                 sum = sum + val + nums[idx];
             }else  if(nums[idx] % 2 == 0 && (nums[idx] + val)%2 == 0){
                 sum = sum + val;
             }else  if(nums[idx] % 2 == 0 && (nums[idx] + val)%2 != 0){
                 sum = sum - nums[idx];
             }
             nums[idx] = nums[idx] + val;
             res[j] = sum;
             j++;
         }
       
        return res;
    }
}