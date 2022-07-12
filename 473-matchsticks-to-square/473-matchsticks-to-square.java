class Solution {
    public boolean makesquare(int[] matchsticks) {
        int side = 0 , pr = 0;
        for(int i : matchsticks){
            pr += i;
        }
        if(pr % 4 != 0){
            return false;
        }
        side = pr/4;
        Arrays.sort(matchsticks);
        
        int[] arr = new int[]{side , side , side , side};
        if(matchsticks[matchsticks.length - 1] > side){
            return false;
        }
        return dfs(matchsticks ,  arr , matchsticks.length - 1);
    }
    public boolean dfs(int[] box , int[] arr , int idx){
        if(idx < 0){
            return (arr[0] == 0)&&(arr[1] == 0)&&(arr[2] == 0)&&(arr[3] == 0);
        }
        for(int i = 0 ; i < 4 ; i++){
            if(box[idx] > arr[i]) continue;
            arr[i] -= box[idx];
            if(dfs(box , arr , idx - 1)) return true;
            arr[i] += box[idx];
        }
        return false;
    }
}