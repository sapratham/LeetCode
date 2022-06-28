class Solution {
    public int minDeletions(String s) {
        int count = 0;
        char[] arr = s.toCharArray();
        
        int[] freq = new int[26];
    
        for(char i : arr){
            freq[i - 'a']++;
        }
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < freq.length ; i++){
            while(freq[i] != 0 && set.contains(freq[i])){
                freq[i]--;
                count++;
            }
            set.add(freq[i]);
        }
        return count;
    }
}