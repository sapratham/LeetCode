class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return ;
        int j = 0;
        
        for(int i = 0; i < m + n ; i++){
            if(i < m){
                continue;
            }else {
                nums1[i] = nums2[j++];
            }
        }
        Arrays.sort(nums1);
    }
}