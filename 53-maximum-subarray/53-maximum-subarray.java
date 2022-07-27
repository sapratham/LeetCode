class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i : nums){
            if(sum > 0){
                sum += i;
            }else{
                sum = i;
            }
            max = Math.max(max , sum);
        }
        return max;
    }
}