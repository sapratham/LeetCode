class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
         
        if(n < 0) return 1.0/solver(x,n*-1);
        else return solver(x,n);
        
    }
    public double solver(double x, int n){
        if(n == 0) return 1;
        if(n == 1) return x;
        double res = solver(x,n/2);
      if(n % 2 == 0){
       
           return res * res;
        }else{
            
           return x*res*res; 
        }  
    }
}