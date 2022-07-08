class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n ; i++){
            sb.append(0);
        }
        
        HashSet<String>  vis = new HashSet();
        vis.add(sb.toString());
        
        int lim = (int)Math.pow(k , n);
        dfs(sb , vis , lim , n , k);
        
        return sb.toString();
    }
    
    public boolean dfs(StringBuilder sb , HashSet<String> vis , int lim , int n , int k){
        if(vis.size() == lim){
            return true;
        }
        String lnm1 = sb.substring(sb.length() - (n-1));
        for(int i = 0 ; i < k ; i++){
            String npwd = lnm1 + i;
            if(!vis.contains(npwd)){
                vis.add(npwd);
                sb.append(i);
                boolean flag = dfs(sb , vis , lim , n , k);
                if(flag){
                    return true;
                }
                vis.remove(npwd);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return false;
    }
}