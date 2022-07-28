class Solution {
    public int trap(int[] height) {
        int leftmax = 0 , rightmax = 0;
        int water = 0 ;
        int left = 0 , right = height.length - 1;
        
        while(left <= right){
            if(height[left] < height[right]){
                if(height[left] < leftmax){
                    water += leftmax - height[left];
                }else{
                    leftmax = height[left];
                }
                left++;
            }else{
                if(height[right] < rightmax){
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