class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length ;
        HashMap<String , Integer> map = new HashMap();
        
        for(int i = 0 ; i < n ; i++){
            String str = "";
            for(int j = 0 ; j < n ; j++){
                str += "." + grid[i][j];
            }
            map.put(str , map.getOrDefault(str , 0) + 1);
        }
        int pair = 0;
        for(int j = 0 ; j < n ; j++){
            String str = "";
            for(int i = 0 ; i < n ; i++){
                str += "." + grid[i][j];
            }
            pair += map.getOrDefault(str , 0);
        }
        return pair;
    }
}