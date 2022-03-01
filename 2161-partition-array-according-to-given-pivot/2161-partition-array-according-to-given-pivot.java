class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> Small = new ArrayList<>();
        ArrayList<Integer> Large = new ArrayList<>();
        int count = 0 ;
        int i = 0 ;
        for(i=0 ; i<nums.length ; i++){
            if(nums[i] < pivot) Small.add(nums[i]);
            
            if(nums[i] == pivot) count++;
            if(nums[i] > pivot) Large.add(nums[i]);
            
        }
      i = 0 ;
        for(int a : Small) nums[i++] = a;
        for(int j = 0 ; j<count ; j++) nums[i++] = pivot;
        for(int b : Large) nums[i++] = b;
        
        return nums;
    }
}