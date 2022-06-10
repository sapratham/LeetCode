class Solution {
    public List<Integer> getRow(int rowIndex) {
        long val = 1;
       int i = rowIndex;
        List<Integer> res = new ArrayList<>();
        for(int j = 0 ; j <= i ; j++){
            res.add((int)val);
            val = val * (i - j)/(j + 1);
        }
        return res;
    }
}