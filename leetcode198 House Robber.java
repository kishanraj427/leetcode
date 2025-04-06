// 198. House Robber

/*  
0ms Beats -> 100%
Memory 41.26MB -> Beats 34.32%

*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++) {
            int a = dp[i-1];
            int b = nums[i];
            if(i > 1) b += dp[i-2];
            dp[i] = Math.max(a, b);
        }
        return dp[n-1];
    }
}