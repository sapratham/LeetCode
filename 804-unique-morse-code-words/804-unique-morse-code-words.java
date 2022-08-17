class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> map = new HashSet<>();
        for(String word : words){
            String s = "";
            for(int i = 0 ;i < word.length() ; i++ ){
                char ch = word.charAt(i);
                s += arr[ch - 'a'];
            }
            map.add(s);
        }
        return map.size();
        }
}