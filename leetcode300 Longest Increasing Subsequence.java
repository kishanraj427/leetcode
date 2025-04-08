// 300. Longest Increasing Subsequence

/*  
51ms Beats -> 32.34%
Memory 44.01MB -> Beats 86.69%

*/

import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 1, n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++) 
            for(int j = 0; j < i; j++) 
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
        return ans;
    }
}