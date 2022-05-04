class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length == 0) return new ArrayList();
        if(nums.length == 1 && nums[0] == 0) return new ArrayList();
        Arrays.sort(nums);
        List<List<Integer>> finalans = new ArrayList();
       
       for(int i = 0 ; i < nums.length - 2 ; i++){
             if (i > 0 && nums[i] == nums[i - 1])  continue;
           int j = i + 1; 
           int k = nums.length - 1;
           while(j < k)
         {  
               int currSum = nums[i] + nums[j] + nums[k];
           if(currSum > 0) k--;
           else if(currSum < 0) j++;
           else{
               finalans.add(Arrays.asList(nums[i] , nums[j] , nums[k]));
               while(j < k && nums[j] == nums[j+1]) j++;
               while(j < k && nums[k] == nums[k-1]) k--;
               j++;
               k--;
           }
           }
       }
        return finalans;
    }
}