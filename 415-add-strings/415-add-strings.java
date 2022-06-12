class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder str = new StringBuilder();
        int c = 0 ;
        for(int i = num1.length() - 1 , j = num2.length() - 1 ; i >= 0 || j >= 0 || c > 0  ; i-- , j--){
           
        int n1 = (i < 0)? 0 : num1.charAt(i) - '0';
        int n2 = (j < 0)? 0 : num2.charAt(j) - '0';
            
           str.append((n1 + n2 + c) % 10);
            c = (n1 + n2 + c)/10;
            
        }
        
        return str.reverse().toString();
    }
}