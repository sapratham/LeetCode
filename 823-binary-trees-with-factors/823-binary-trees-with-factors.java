class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        long res = 1;
        long MOD = 1000000007;
        Arrays.sort(arr);
        HashMap<Integer , Long > map = new HashMap<>();
        map.put(arr[0] , res);
        for(int i = 1 ; i < arr.length ; i++){
            long count = 1;
            map.put(arr[i] , count);
            for(int j = 0 ; j < i ; j++){
              if(arr[i] % arr[j] == 0 && map.containsKey(arr[i]/arr[j]))
               count += map.get(arr[i]/arr[j]) * map.get(arr[j]);
            }
            map.put(arr[i] , count);
            res += count;
        }
        return (int)(res%MOD);
    }
}