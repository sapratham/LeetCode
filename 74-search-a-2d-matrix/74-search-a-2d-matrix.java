class Solution {
    public boolean binarySearch(int[] arr,int target){
        int left = 0 , right = arr.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(arr[mid] == target) return true;
           else if(arr[mid] > target) right = mid-1;
            else left = mid + 1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0 ; i < matrix.length ; i++)
        {
           if(binarySearch(matrix[i] , target)) return true;
        }
        return false;
    }
}