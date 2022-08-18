class Solution {
    public int minSetSize(int[] arr) {
       HashMap<Integer , Integer> map = new HashMap<>();
        
        int n = arr.length; 
        
       for(int i : arr){
           map.put(i , map.getOrDefault(i , 0) + 1);
       }
       PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
        for(int i : map.values()){
            pq.add(i);
        }
        
        int count = 0 ;
        while(n > arr.length/2){
            n -= pq.poll();
            count++;
        }
        return count;
        
    }
}