class Solution {
    public int maxProduct(String[] words) {
       
        
        int ans = Integer.MIN_VALUE;
        
       for(int i = 0 ; i < words.length - 1; i++){
           for(int j = i+1 ; j < words.length ; j++){
               if(checkcommon(words[i] , words[j])){
                   ans = Math.max(words[i].length()*words[j].length() , ans);
               }
           }
       }
        return (ans == Integer.MIN_VALUE)? 0:ans;
    }
    public boolean checkcommon(String a , String b){
        boolean[] vis = new boolean[26];
        Arrays.fill(vis,false);
        for(int i = 0 ; i < a.length() ; i++){
            char c = a.charAt(i);
            vis[c - 'a'] = true;
        }
        for(int i = 0 ; i < b.length() ; i++){
            char c = b.charAt(i);
            if(vis[c -'a'] == true){
                return false;
            }
        }
        return true;
    }
}