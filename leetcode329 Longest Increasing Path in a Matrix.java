// 329. Longest Increasing Path in a Matrix

/*  
7ms -> Beats 96.84%
Memory 45.00MB -> Beats 79.10%
*/

import java.util.*;

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, doWork(matrix, i, j, -1, dp));
            }
        }
        return max;
    }

    int doWork(int[][] matrix, int m, int n, int prev, int[][] dp) {
        if(m < 0 || n < 0 || m >= matrix.length || n >= matrix[0].length) return 0;
        if(matrix[m][n] > prev) {
            if(dp[m][n] != -1) return dp[m][n];
            int a = doWork(matrix, m-1, n, matrix[m][n], dp);
            int b = doWork(matrix, m, n-1, matrix[m][n], dp);
            int c = doWork(matrix, m+1, n, matrix[m][n], dp);
            int d = doWork(matrix, m, n+1, matrix[m][n], dp);
            return dp[m][n] = 1 + Math.max(a, Math.max(b, Math.max(c, d)));
        }
        return 0;
    }
}