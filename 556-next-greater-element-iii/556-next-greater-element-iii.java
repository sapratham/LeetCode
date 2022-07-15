class Solution {
    public int nextGreaterElement(int n) {
   char[] number = (n + "").toCharArray();
        
        int i;
        for(i = number.length - 1; i>0; i--) {
            if(number[i-1] < number[i]) {
                break;
            }
        }
        
        if(i == 0) {
            return -1;
        }
        
        int j;
        for(j = number.length - 1; j>=0; j--) {
            if(number[j] > number[i-1]) {
                break;
            }
        }
        
        char temp = number[i - 1];
        number[i - 1] = number[j];
        number[j] = temp;
        
        Arrays.sort(number, i, number.length);
        long ans = Long.parseLong(String.valueOf(number));
        return (ans > Integer.MAX_VALUE? -1 : (int)ans);
    }
    // public void swap(char[] arr , int i , int j){
    //     char temp = arr[i];
    //     arr[i] = arr[j];
    //     arr[j] = temp;
    // }
    // public void reverse(char[] arr , int i , int j){
    //     while( i <= j){
    //         swap(arr , i , j);
    //     }
    // }
}