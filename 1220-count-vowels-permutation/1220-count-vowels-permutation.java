class Solution {
    public int countVowelPermutation(int n) {
        long a = 1 , e = 1 , i = 1 , o = 1 , u = 1 ;
        long MOD = 1000000007;
        long a2 = 0 , e2 = 0 , i2 = 0 , o2 = 0 , u2 = 0;
        for(int x = 2; x <= n ; x++){
            a2 = (e + i + u) % MOD;
            e2 = (a + i ) % MOD;
            i2 = (e + o) % MOD;
            o2 = i;
            u2 = (o + i) % MOD;
            
            a = a2;
            e = e2;
            i = i2;
            o = o2;
            u = u2;
        }
        return (int)((a + e + i + o + u) % MOD);
    }
}