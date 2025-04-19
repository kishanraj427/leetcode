// 50. Pow(x, n)

/*  
0ms Beats -> 100%
Memory 42.64MB -> Beats 31.65%

*/

class Solution {
    public double myPow(double x, int n) {
        long N = n; 
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return powHelper(x, N);
    }

    private double powHelper(double x, long n) {
        if (n == 0) return 1;
        double half = powHelper(x, n / 2);
        double result = half * half;
        if (n % 2 == 1) {
            result *= x;
        }
        return result;
    }
}