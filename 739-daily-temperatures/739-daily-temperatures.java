class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        int[] res = new int[temperatures.length];
        for(int i = 1 ; i < temperatures.length ; i++ ){
            while(stk.size() > 0 && temperatures[stk.peek()] < temperatures[i]){
                res[stk.peek()] = i - stk.peek();
                stk.pop();
            }
            stk.push(i);
        }
        return res;
    }
}