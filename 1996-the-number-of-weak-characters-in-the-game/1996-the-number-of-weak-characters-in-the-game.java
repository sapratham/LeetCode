class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties , (a,b) -> (a[0] == b[0])? Integer.compare(b[1],a[1]) : Integer.compare(a[0],b[0]));
        int count = 0;
        int len = properties.length;
        int max = properties[len-1][1];
        
        for(int i = len - 2 ; i >= 0 ;i--){
            if(max > properties[i][1]){
                count++;
            }else{
                max = properties[i][1];
            }
        }
       
        return count;
    }
}