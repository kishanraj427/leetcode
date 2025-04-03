// 91. Decode Ways

/*  
Runtime 1ms -> Beats 82.95%
Memory 41.80MB -> Beats 64.12%
*/

class Solution {
    public int numDecodings(String s) {
        if(s.contains("00") || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        int n = s.length();
        for(int i = 1; i <= n; i++) {
            int a = 0, b = 0;
            if(i > 1 && s.charAt(i-2) != '0') {
                int val = Integer.parseInt(s.substring(i-2, i));
                if(val < 27 && val > 0)
                    a = dp[i-2];
            } 
            if(s.charAt(i-1) != '0') {
                b = dp[i-1];
            }
            dp[i] = a+b;
        }
        return dp[n];
    }
}