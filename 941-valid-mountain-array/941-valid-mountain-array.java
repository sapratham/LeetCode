class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        int left = 0 , right = arr.length -1;
        while(arr[left+1] > arr[left] && left+1 < arr.length-1) left++;
        while(arr[right] < arr[right-1] && right-1 > 0) right--;
        return left == right;
    }
}