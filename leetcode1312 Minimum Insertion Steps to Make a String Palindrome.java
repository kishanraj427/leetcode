// 1312. Minimum Insertion Steps to Make a String Palindrome

/*  
28ms -> Beats 33.77%
Memory 45.44MB -> Beats 66.23%
*/

class Solution {
        public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= n; ++j)
                dp[i][j] = s.charAt(i-1) == s.charAt(n - 1 - (j - 1)) ? 
                    dp[i-1][j-1] + 1 : Math.max(dp[i-1][j], dp[i][j-1]);
        return n - dp[n][n];
    }
}