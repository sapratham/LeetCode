class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> res = new ArrayList<>();
        int j = 1;
        int i = 0;
        while(i < target.length){
            if(j == target[i]){
                i++;
                res.add("Push");
            }else{
                res.add("Push");
                res.add("Pop");
            }
            j++;
        }
        return res;
    }
}