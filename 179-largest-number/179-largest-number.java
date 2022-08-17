class Solution {
    public String largestNumber(int[] nums) {
        
        String[] str = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            str[i] = nums[i] + "";
        }
        Arrays.sort(str , (a , b) -> {
            String case1 = a + b;
            String case2 = b + a;
            return case2.compareTo(case1);
        });
        
        if(str[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str.length ; i++){
            sb.append(str[i]);
        }
        return sb.toString();
        }
}