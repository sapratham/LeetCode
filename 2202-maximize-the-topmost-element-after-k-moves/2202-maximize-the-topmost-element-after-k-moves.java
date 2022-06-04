class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if (n == 1 && k % 2 == 1) return -1;
        int furthestReachable = Math.min(n, k - 1);
        int firstMax = -1, secondMax = -1;
        for (int i = 0; i < furthestReachable; i++) {
            firstMax = Math.max(firstMax, nums[i]);
        } 
        if (k < n) secondMax = nums[k];
        return Math.max(firstMax, secondMax);
    }
}