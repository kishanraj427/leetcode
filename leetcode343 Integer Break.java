// 343. Integer Break

/*  
0ms Beats -> 100%
Memory 40.55MB -> Beats 39.46%
*/

import java.util.*;
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        if(n <= 2) return 1;
        if(n == 3) return 2;
        return breakDown(n, dp);
    }

    int breakDown(int n, int[] dp) {
        if(n <= 1) return 1;
        if(dp[n] != -1) return dp[n];
        int max = 0;
        for(int i = 0; i <= (n/2) + 1; i++) {
            if(i == 0) {
                max = n;
                continue;
            }
            int data = i * breakDown(n-i, dp);
            max = Math.max(max, data);
        }
        return dp[n] = max;
    }
}