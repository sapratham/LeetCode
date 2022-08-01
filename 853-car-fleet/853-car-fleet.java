class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer , Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0 ; i < speed.length ; i++){
            map.put(position[i] , speed[i]);
        }
        
        int ans = 0 ;
        double time = 0;
        for(int i : map.keySet()){
            int currSpeed = map.get(i);
            double currTime = (target - i)*1.0 / currSpeed;
            
            if(currTime > time){
                time = currTime;
                ans++;
            }
        }
        return ans;
    }
}