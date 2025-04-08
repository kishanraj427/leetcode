// 264. Ugly Number II

/*  
2ms Beats -> 97.17%
Memory 41.83MB -> Beats 61.30%
*/

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int twoI = 0, threeI = 0, fiveI = 0;
        for(int i = 1; i < n; i++) {
            int twoMul = dp[twoI] * 2;
            int threeMul = dp[threeI] * 3;
            int fiveMul = dp[fiveI] * 5;
            dp[i] = Math.min(twoMul, Math.min(threeMul, fiveMul));
            if(dp[i] == twoMul) twoI++;
            if(dp[i] == threeMul) threeI++;
            if(dp[i] == fiveMul) fiveI++; 
        }
        return dp[n-1];
    }
}