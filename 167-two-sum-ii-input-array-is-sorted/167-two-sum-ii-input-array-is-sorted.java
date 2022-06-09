class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0 , k = numbers.length - 1;
        while(i < k){
            int sum = numbers[i] + numbers[k];
            if(sum == target){
                res[0] = i + 1;
                res[1] = k + 1;
                return res;
            }else if(sum < target){
                i++;
            }else{
                k--;
            }
        }
        return res;
    }
}