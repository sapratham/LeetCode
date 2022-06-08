class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }
        
       if(isPalindrome(s)){
           return 1;
       }else{
           return 2;
       }
    }
    public boolean isPalindrome(String s){
        int i = 0 , j = s.length() - 1;
        while(i <= j){
          if(s.charAt(i++) != s.charAt(j--))
          {
              return false;
          }
        }
        return true;
    }
}