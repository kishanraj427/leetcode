// 120. Triangle

/*  
Runtime 3ms -> Beats 64.99%
Memory 44.12MB -> Beats 66.95%
*/

import java.util.*;

class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int n = tri.size();
        int[][] dp = new int[n][n];
        dp[0][0] = tri.get(0).get(0);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i+1; j++) {
                int a = tri.get(i).get(j);
                int b = 10000, c = 10000;
                if(j != 0) b = dp[i-1][j-1];
                if(i != j) c = dp[i-1][j];
                dp[i][j] = a + Math.min(b, c);
            }   
        }
        return getMin(dp[n-1]);
    }

    int getMin(int[] list) {
        int min = list[0];
        for(int i = 1; i < list.length; i++) {
            if(min > list[i]) min = list[i];
        }
        return min;
    }
}