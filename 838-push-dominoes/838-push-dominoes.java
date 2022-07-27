class Solution {
    public String pushDominoes(String s) {
        s = "L" + s + "R";
        char[] arr = s.toCharArray();
        
        int prev = 0;
        for(int i = 1 ; i <= arr.length - 1 ; i++){
            if(arr[i] == 'L'){
               
                 if(arr[prev] == 'L'){
                     for(int j = prev ; j < i ; j++){
                         arr[j] = 'L';
                     }
                 }else if(arr[prev] == 'R'){
                     int low = prev;
                     int high = i;
                     while(low < high){
                         arr[low] = 'R';
                         arr[high] = 'L';
                         low++;
                         high--;
                     }
                 }
                prev = i;
            }else if(arr[i] == 'R'){
                
                 if(arr[prev] == 'R'){
                     for(int j = prev ; j < i ; j++){
                         arr[j] = 'R';
                     }
                 }else if(arr[prev] == 'L'){
                    // do nothing
                     }
                prev = i;
            }
            
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < arr.length - 1 ; i++){
            sb.append(arr[i]);
        }
        
        return sb.toString();
    }
}