class Solution {
    public int candy(int[] rating) {
        int candies =  0;
        int n = rating.length;
        int[] left2right = new int[n];
        int[] right2left = new int[n];
        
        Arrays.fill(left2right , 1);
        Arrays.fill(right2left , 1);
        // left to right
        for(int i = 1 ; i < n ; i++){
            if(rating[i-1] < rating[i]){
                left2right[i] = left2right[i-1] + 1;
            }
        }
        
        // right to left
        for(int i = n - 2; i >= 0 ; i--){
            if(rating[i+1] < rating[i]){
                right2left[i] = right2left[i+1] + 1;
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            candies += Math.max(left2right[i] , right2left[i]);
        }
        return candies;
    }
}