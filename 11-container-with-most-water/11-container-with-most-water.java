class Solution {
    public int maxArea(int[] height) {
        int left = 0 , right = height.length - 1;
        int area = 0;
        while(left <= right){
           int area1 = 0;
            if(height[left] < height[right]){
                area1 = height[left]*(right - left);
                left++;
            }else{
                area1 = height[right]*(right - left);
                right--;
            }
            area = Math.max(area, area1);
        }
        return area;
    }
}