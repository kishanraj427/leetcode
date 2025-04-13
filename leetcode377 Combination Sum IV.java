// 377. Combination Sum IV

/*  
0ms Beats -> 100%
Memory 40.86MB -> Beats 79.90%
*/

import java.util.*;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, -1);
        return combination(nums, target, 0, dp);  
    }
    
    int combination(int[] nums, int target, int sum, int[] dp) {
        if(sum == target) return 1;
        int count = 0;
        if(dp[sum] != -1) return dp[sum];
        for(int ind = 0; ind < nums.length; ind++) {
                if(sum + nums[ind] <= target) {
                        count += combination(nums, target, sum+nums[ind], dp);	
                }
        }
        return dp[sum] = count;
    }
}