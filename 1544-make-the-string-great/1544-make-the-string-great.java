class Solution {
    public String makeGood(String s) {
        Stack<Character> stk = new Stack<>();
        for(char ch : s.toCharArray()){
            if(stk.size() > 0){
                if(stk.peek() == (ch + 32) || stk.peek() == (ch - 32)){
                    stk.pop();
                }else{
                    stk.push(ch);
                }
            }else
            stk.push(ch);
        }
       StringBuilder sb = new StringBuilder();
        while(stk.size() > 0){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}