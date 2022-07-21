class Solution {
    String[] str = new String[]{"" , "" , "abc" ,"def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuv" , "wxyz"};
    List<String> res ;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        solve(digits , 0 , new StringBuilder());
        return res;
    }
    public void solve(String digits , int idx , StringBuilder sb){
        int n = digits.length();
        if(idx == n){
            res.add(sb.toString());
            return;
        }
        
        int val = digits.charAt(idx) - '0';
        String combination = str[val];
        for(int i = 0 ; i < combination.length() ; i++){
            sb.append(combination.charAt(i));
            solve(digits , idx + 1 , sb);
            sb.deleteCharAt(sb.length() -1);
        }
        
    }
}