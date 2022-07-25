class Solution {
    public int reachNumber(int target) {
        int step = 0;
        target = Math.abs(target);
        
        while(true){
            int range = step * (step + 1) / 2;
            if(range >= target && range % 2 == target % 2){
                break;
            }
            step++;
        }
        return step;
    }
}