class Solution {
    public String oddString(String[] words) {
        HashMap<String , Integer> map = new HashMap();
        for(String word : words){
            String str = solve(word);
                if(map.containsKey(str)){
                    map.put(str , map.get(str) + 1);
                }else{
                    map.put(str , 1);
                }
        }
        for(String word : words){
            String str = solve(word);
           if(map.get(str) == 1){
               return word;
           }
        }
        return "";
    }
    public String solve(String word){
        String str = "";
        for(int i = 1 ; i < word.length() ; i++){
            int a = word.charAt(i) - word.charAt(i - 1) - 'a';
            str = str + a + ",";
        }
        return str;
    }
}