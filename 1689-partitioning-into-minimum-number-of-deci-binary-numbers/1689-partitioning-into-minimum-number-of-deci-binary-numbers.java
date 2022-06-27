class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for(int i = 0 ; i < n.length() ; i++){
            char ch = n.charAt(i);
            if(ch - '0' % 9 == 0) return 9;
            else{
                max = Math.max(max , ch - '0');
            }
        }
        return max;
    }
}