class Solution {
    public boolean find132pattern(int[] nums) {
      if(nums == null || nums.length < 3) return false;
       Stack<Integer> stk = new Stack();
       int j = Integer.MIN_VALUE;
        for(int i = nums.length-1 ; i >= 0 ; i--){
            if(nums[i] < j) return true;
            else
                while(!stk.isEmpty() && stk.peek() < nums[i]) j = stk.pop();
               stk.push(nums[i]);
        }
        return false;
        
    }
}