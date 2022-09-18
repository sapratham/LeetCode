class Solution {
    public int trap(int[] height) {
        int water = 0 ;
        int left = 0 ; 
        int right = height.length - 1;
        int leftmax = 0 , rightmax = 0;
        while(left <= right){
           if(height[left] < height[right]){
               if(leftmax > height[left]){
                 water += leftmax - height[left];  
               }else{
                   leftmax = height[left];
               }
               
               left++;
           }else{
               if(rightmax > height[right]){
                  water += rightmax - height[right]; 
               }else{
                   rightmax = height[right];
               }
               
               right--;
           }
        }
        return water;
    }
}