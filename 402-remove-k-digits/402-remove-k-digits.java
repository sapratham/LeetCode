class Solution {

    public String removeKdigits(String num, int k) {
        if (num == "" || k == 0) return num;
        Stack<Character> stk = new Stack<>();
        stk.push(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (stk.size() > 0 && stk.peek() > ch && k > 0) {
                stk.pop();
                k--;
            }
            stk.push(ch);
        }
        while(k > 0){
            stk.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (stk.size() > 0) {
            char ch = stk.pop();
            sb.append(ch);
        }
        for(int i = sb.length() - 1 ; i >= 0 ; i--){
            if(sb.charAt(i) == '0'){
                sb.deleteCharAt(i);
            }else{
                break;
            }
        }
        
        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}
