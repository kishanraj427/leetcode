// 313. Super ugly Number

/*  
51ms -> Beats 48.52%
Memory 46.32MB -> Beats 29.98%
*/

import java.util.*;
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] dp = new long[n];
        dp[0] = 1;
        int[] indies = new int[primes.length]; 
        Arrays.fill(indies, 0);
        for(int i = 1; i < n; i++) {
            long[] mulVal = new long[primes.length];
            for(int j = 0; j < primes.length; j++) {
                mulVal[j] = primes[j] * dp[indies[j]]; 
            }
            dp[i] = getMin(mulVal);
            for(int j = 0; j < primes.length; j++) {
                if(mulVal[j] == dp[i]) indies[j]++; 
            }
        }
        return (int) dp[n-1];
    }

    long getMin(long[] list) {
        long min = list[0];
        for(int i = 0; i < list.length; i++) min = Math.min(min, list[i]);
        return min;
    }
}