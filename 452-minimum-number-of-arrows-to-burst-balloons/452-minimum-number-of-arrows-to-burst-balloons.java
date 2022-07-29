class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points , (a, b)->{
            if(a[0] > b[0]){
                return 1;
            }else if(a[0] == b[0]){
                return 0;
            }else{
                return -1;
            }
        });
        
        int count = 0;
        int end = Integer.MAX_VALUE;
        for(int[] point : points){
            if(point[0] > end){
                count++;
                end = point[1];
            }else{
                end = Math.min(end , point[1]);
            }
        }
        return count + 1;  
    }
}