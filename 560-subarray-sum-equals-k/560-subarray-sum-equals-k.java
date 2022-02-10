class Solution {
public int subarraySum(int[] nums, int k) {
	var count = 0;
	for (int start = 0; start < nums.length; start++)
		for (int end = start, sum = 0; end < nums.length; end++) {
			sum += nums[end];
			if (sum == k)
				count++;
		}
	return count;
}
}