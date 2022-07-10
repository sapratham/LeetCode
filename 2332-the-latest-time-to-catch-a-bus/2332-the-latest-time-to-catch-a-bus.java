class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        HashSet<Integer> set = new HashSet<>();
        int latesttime = 0 , j = 0 ;
        for(int i = 0 ; i < buses.length ; i++){
            int cap = 0 ;
            while(cap < capacity && j < passengers.length && passengers[j] <= buses[i]){
                if(!set.contains(passengers[j] - 1)){
                    latesttime = passengers[j] - 1;
                }
                set.add(passengers[j]);
                j++;
                cap++;
            }
            if(cap < capacity && !set.contains(buses[i])){
                latesttime = buses[i];
            }
        }
        return latesttime;
    }
}