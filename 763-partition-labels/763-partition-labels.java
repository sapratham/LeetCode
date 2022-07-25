class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] map = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            map[ch - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i = start ; i < s.length() ; i++){
            char ch = s.charAt(i);
            end = Math.max(end , map[ch - 'a']);
            
            if(i == end){
                res.add(end - start + 1);
                start = end = i + 1;
            }
        }
        
        return res;
    }
}