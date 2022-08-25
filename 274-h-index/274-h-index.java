class Solution {
    public int hIndex(int[] citations) {
        int ans = Integer.MIN_VALUE;
        Arrays.sort(citations);
        int k = 1;
        for(int i = citations.length - 1 ; i >= 0 ; i--){
            if(citations[i] >= k){
                ans = Math.max(ans , k);
                k++;
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}