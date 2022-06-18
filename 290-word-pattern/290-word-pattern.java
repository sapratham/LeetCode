class Solution {
    public boolean wordPattern(String pattern, String s) {
       HashMap<String, String> map = new HashMap();
        String[] arr = s.split(" ");
        if(pattern.length() != arr.length){
            return false;
        }
        for(int i = 0 , j = 0 ;i < pattern.length() ; i++ , j++){
            String str = pattern.substring(j,i + 1);
            if(map.containsKey(str)){
             String check = map.get(str);
             if(!arr[i].equals(check))
                return false;
            }else{
                if(map.containsValue(arr[i])){
                    return false;
                }
            }
            
           map.put(str, arr[i]); 
        }
        return true;
    }
}