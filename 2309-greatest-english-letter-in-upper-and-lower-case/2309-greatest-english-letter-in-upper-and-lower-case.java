class Solution {
    public String greatestLetter(String s) {
        String ans = new String();
        int[] lower = new int[26];
        int[] upper = new int[26];
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            
            if(ch >= 'a' && ch <= 'z'){
                lower[ch - 'a']++;
            }
            if(ch >= 'A' && ch <= 'Z'){
                upper[ch - 'A']++;
            }
            
        }
        for(int i = 25 ; i >= 0 ; i--){
           if(lower[i] > 0 && upper[i] > 0){
               ans = Character.toString(i + 'A');
               return ans;
           } 
        }
        return ans;
    }
}