class Solution {
     int mod = (int) 1e9 + 7;
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        long height = getMax(horizontalCuts , h) % mod;
        long width = getMax(verticalCuts , w) % mod;
        
        return (int)(height*width % mod);
    }
    public long getMax(int[] arr , int max){
        long maximum = 0;
        maximum = Math.max(maximum , arr[0]) % mod;
        for(int i = 1 ; i < arr.length ; i++ ){
            long num = arr[i];
            maximum = Math.max(maximum , num - arr[i-1]);
        }
        maximum = Math.max(maximum , max - arr[arr.length - 1]) % mod;
        return maximum % mod;
    }
}