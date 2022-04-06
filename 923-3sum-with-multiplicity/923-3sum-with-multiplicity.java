class Solution {
  public int threeSumMulti(int[] arr, int target) {
        int mod = 1000000007;
        
        int count = 0;
        Arrays.sort(arr);
        for (int index = 0; index < arr.length - 2; index++) {
            int start = index + 1;
            
            int end = arr.length - 1;
            while (start < end) {
                if (arr[start] + arr[end] + arr[index] == target) {
 
                    if (arr[start] == arr[end]) {
                        count += nCr(end - start + 1);
                        count %= mod;
                        break;
                    }
                    int i = 1, j = 1;
                    while (start + 1 < end && arr[start] == arr[start + 1]) {
                        start++;
                        i++;
                    }
                    while (start + 1 < end && arr[end] == arr[end - 1]) {
                        end--;
                        j++;
                    }
                    count += (i * j);
                    count %= mod;
                    start++;end--;                  
                } else if (arr[start] + arr[end] + arr[index] > target) end--;
                else start++;
            }
        }
        return count % mod;
    }
    private static int nCr(int n) {
        return n * (n - 1) / 2;
    }
}