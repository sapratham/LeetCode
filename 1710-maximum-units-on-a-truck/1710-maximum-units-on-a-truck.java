class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes , (a,b) -> -Integer.compare(a[1],b[1]));
        int res = 0;
        for(int[] box : boxTypes){
            if(truckSize <= box[0]){
                return truckSize*box[1] + res;
            }
            res += box[0]*box[1];
            truckSize -= box[0];
        }
        return res;
    }
}