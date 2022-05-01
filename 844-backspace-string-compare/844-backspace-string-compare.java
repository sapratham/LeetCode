class Solution {
    public boolean backspaceCompare(String s, String t) {
       if(s == t)  return true;
        return clearString(s).equals(clearString(t));
    }
    public String clearString(String S){
        StringBuilder str = new StringBuilder();
        for(char c : S.toCharArray()){
            if(c == '#'){
                if(str.length() == 0) continue;
                str.deleteCharAt(str.length() - 1);
                
                }
            else{
                str.append(c);
            }
        }
        return str.toString();
    }
}