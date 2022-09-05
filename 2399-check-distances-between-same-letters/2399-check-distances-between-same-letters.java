class Solution {
    public boolean checkDistances(String s, int[] distance) {
        HashMap<Character , Integer > map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch ,i - map.get(ch)- 1);
                int index = ch - 'a';
                if(map.get(ch) != distance[index]){
                    return false;
                }
            }else{
                map.put(ch, i);
            }
        }
        return true;
    }
}