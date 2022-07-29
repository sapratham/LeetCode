class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        ArrayList<String> ans = new ArrayList<>();
    
        for(String word : words){
            if(solve(word , pattern)){
                ans.add(word);
            }
        }
        return ans;
    }
    public boolean solve(String a , String b){
        if(a.length() != b.length()) return false;
        for(int i = 0 ; i < a.length() ; i++){
            if(a.indexOf(a.charAt(i)) != b.indexOf(b.charAt(i))) return false;
        }
        return true;
    }
}