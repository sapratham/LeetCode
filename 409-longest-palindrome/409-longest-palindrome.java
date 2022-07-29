class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128];
        
       
        for(char ch : s.toCharArray()){
           freq[ch]++;
        }
        int count = 0;
        for(int i = 0 ; i < freq.length ; i++){
            if(freq[i] % 2 == 0){
                count += freq[i];
            }else{
                count += freq[i] - 1;
            }
        }
        
        return count < s.length() ? count + 1: count;
    }
}