class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return 0;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        if(arr == nums) return 0;
        int i = 0 , j = nums.length - 1;
        while(i < j){
            if(arr[i] == nums[i] && arr[j] == nums[j]) {
                i++;
                j--;
            }
            else if(arr[i] == nums[i]) i++;
            else if(arr[j] == nums[j]) j--;
            else return j - i + 1;
        }
        return 0;
    }
}