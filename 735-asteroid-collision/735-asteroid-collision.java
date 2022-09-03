class Solution {
    public int[] asteroidCollision(int[] asteroids){
        Stack<Integer> stk = new Stack<>();
        
        for(int i : asteroids){
           if(i > 0){
               stk.push(i);
           } else{
               while(stk.size() > 0 && stk.peek() > 0 && stk.peek() < -i){
                   stk.pop();
               }
               if(stk.size() > 0 && stk.peek() == -i){
                   stk.pop();
               }else if(stk.size() > 0 && stk.peek() > -i) {
                   continue;
               }else{
                   stk.push(i);
               }
           }
        }
        
        int[] ans = new int[stk.size()];
        for(int i = ans.length - 1 ; i >= 0 ; i--){
             ans[i] = stk.peek();
            stk.pop();
        }
        
        return ans;
    }
}