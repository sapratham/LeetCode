class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length +1 - k];
        int idx = 0 ;
        
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i<nums.length ; i++){
            if(q.size() > 0 && q.getFirst() <= i-k){
                q.removeFirst();
            }
            while(q.size() > 0 && nums[q.getLast()] < nums[i]){
                q.removeLast();
            }
            q.addLast(i);
            
            if(i >= k-1){
                res[idx++] = nums[q.getFirst()];
            }
        }
        return res;
    }
}