class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0 ;
        int j = 0 ;
        
        int c = 0 ;
        int res = 0 ;
        
        while( i < nums.length ){
            if(nums[i] == 0){
                c++;
            }
            while(c > k){
                if(nums[j] == 0){
                    c--;
                }
                j++;
            }
            int len = i - j + 1;
            res = Math.max(res , len);
            i++;
        }
        return res;
    }
}