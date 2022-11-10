class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stk = new Stack();
        for(char ch : s.toCharArray()){
           if(stk.size() == 0 || stk.peek() != ch){
               stk.push(ch);
           }else{
               stk.pop();
           }
        
        }
        StringBuilder sb = new StringBuilder();
        while(stk.size() > 0){
            sb.append(stk.pop());
            
        }
        return sb.reverse().toString();
        
    }
}