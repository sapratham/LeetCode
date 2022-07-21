class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] freqmap = new int[60];
        int count = 0;
        for(int t : time){
            int val = t % 60;
            if(val == 0){
                count += freqmap[0];
            }else{
                count += freqmap[60 - val];
            }
            freqmap[val]++;
        }
        return count;
    }
}