class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        ArrayList<String> res = new ArrayList<>();
        int[] count = new int[26];
        for(String word2 : words2){
            int[] freq2 = new int[26];
            count(word2 , freq2);
            for(int i = 0 ; i < 26 ; i++){
                count[i] = Math.max(count[i] , freq2[i]);
            }
        }
       
        for(String word1 : words1){
            int[] freq1 = new int[26];
            count(word1 , freq1);
            for(int i = 0 ; i < 26 ; i++){
                if(freq1[i] < count[i]){
                    break;
                }
                if(i == 25){
                    res.add(word1);
                }
            }
        }
        
        return res;
    }
    public void count(String s , int[] freq){
        
        for(int i = 0 ; i < s.length() ; i++){
            freq[s.charAt(i) - 'a']++;
        }
    }
}