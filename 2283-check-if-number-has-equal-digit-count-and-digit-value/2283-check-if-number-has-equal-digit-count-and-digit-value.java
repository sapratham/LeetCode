class Solution {
    public boolean digitCount(String num) {
         
        int  indexCount[] = new int[10];
        
        for(char c:num.toCharArray()){
            indexCount[c-'0']++;
        }
        
        for(int i=0;i<num.length();i++){
            if(Character.getNumericValue(num.charAt(i)) != indexCount[i])
            return false;   
        }
            
        return true;
    }
}
  