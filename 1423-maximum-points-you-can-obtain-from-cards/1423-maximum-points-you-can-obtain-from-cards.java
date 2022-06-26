class Solution {
    public int maxScore(int[] cardPoints, int k) {
          int n = cardPoints.length ;
          int sum = 0;
            for(int i : cardPoints){
                sum += i;
           }
        if(n == k) return sum;
        int sumofnonpicked = 0;
        int ans = 0;
        for(int i = 0 ; i < n -k - 1 ; i++){
           sumofnonpicked += cardPoints[i]; 
        }
        for(int i = n - k - 1 ; i < n ; i++){
            sumofnonpicked += cardPoints[i];
            ans = Math.max(ans , sum - sumofnonpicked);
            sumofnonpicked -= cardPoints[i -(n-k-1)];
        }
        
        return ans;
    }
}