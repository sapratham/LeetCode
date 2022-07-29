class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int allsum = 0;
        int currsum = 0;
        int ans = 0;
        
        for(int i = 0 ; i < gas.length ; i++){
            allsum += (gas[i] - cost[i]);
            currsum += (gas[i] - cost[i]);
            
            if(currsum < 0){
                ans = i + 1;
                currsum = 0;
            }
        }
        
        if(allsum < 0){
            return -1;
        }else{
            return ans;
        }
    }
}