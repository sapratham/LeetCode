class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> sorted = new ArrayList<>(nums.length);
        List<Integer> counts = new ArrayList<>(nums.length);
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = binarySearch(sorted, nums[i], 0, sorted.size());
            sorted.add(index, nums[i]);
            counts.add(index);
        }
        Collections.reverse(counts);
        return counts;
    }
    
    private int binarySearch(List<Integer> sorted, int value, int start, int end) {
        if (start >= end) return end;
        int mid = start + (end - start) / 2;
        int midVal = sorted.get(mid);
        if (value <= midVal) return binarySearch(sorted, value, start, mid);
        else return binarySearch(sorted, value, mid + 1, end);
    }
}