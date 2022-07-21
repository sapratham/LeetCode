class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        TreeSet<Integer> set = new TreeSet<>();
        for(int[] trip : trips){
            int people = trip[0];
            int from = trip[1];
            int to = trip[2];
            
            arr[from] += people;
            set.add(from);
            
            arr[to] -= people;
            set.add(to);
        }
        int res = 0;
        for(int i : set){
             int delta = arr[i];
            res += delta;
            if(res > capacity){
                return false;
            }else if(res < 0){
                res = 0;
            }
        }
        return true;
    }
}