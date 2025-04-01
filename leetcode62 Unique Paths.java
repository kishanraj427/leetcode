// 62. Unique Paths

/*  
Runtime 0ms -> Beats 100.00%
Memory 40.55MB -> Beats 46.61%
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) dp[i][1] = 1;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                int a = dp[i-1][j];
                int b = dp[i][j-1];
                dp[i][j] = a + b;
            }
        }
        return dp[m][n];
    }
}