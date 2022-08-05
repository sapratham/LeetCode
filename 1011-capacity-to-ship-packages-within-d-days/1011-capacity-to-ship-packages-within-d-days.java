class Solution {
    public int shipWithinDays(int[] nums, int m) {
            int hi = 0;                   // highest sum allowed
        int lo = Integer.MIN_VALUE;  // lowest sum allowed
        
        for(int num : nums){
            hi += num;
            lo = Math.max(lo , num);
        }
        
        while(lo < hi){
            int mid = ( lo + hi )/2;
            int limit = mid;
            
            int countParts = 1;
            int currPartSum = 0;
            for(int n : nums){
                if(currPartSum + n <= limit){
                    currPartSum += n;
                }else{
                    currPartSum = n;
                    countParts++;
                }
            }
            if(countParts > m){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return lo;
    }
}