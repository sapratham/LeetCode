class Solution {
    public int lengthOfLIS(int[] nums) {
       ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
       
      for(int i=1;i<nums.length;i++)
      {
          if(nums[i]>list.get(list.size()-1))
          list.add(nums[i]);
          
          else 
          list.set(lowerBound(list,0,list.size()-1, nums[i]),nums[i]);
       }
        return list.size();
    }
    public int lowerBound(ArrayList<Integer> list, int low, int high, int n)
    {
        while(low<high)
        {
            int mid = low+(high-low)/2;
            
            if(list.get(mid)>=n)
                high = mid;
            else 
                low = mid+1;
        }
        
        return low;
    }
}