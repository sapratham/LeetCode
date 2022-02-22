class Solution {
    public int titleToNumber(String s) {
        if(s.length() == 0) return 0;
        else{
        return ((s.charAt(s.length()-1)-'A'+1)+ 26*titleToNumber(s.substring(0,s.length()-1)));
        }
    }
}