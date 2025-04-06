// 213. House Robber II

/*  
0ms Beats -> 100%
Memory 41.16MB -> Beats 49.49%
*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] list1 = new int[n-1];
        int[] list2 = new int[n-1];
        int i1 = 0, i2 = 0;
        for(int x : nums) {
            if(i1 != n-1){
                list1[i1++] = x;
            } else {
                i1++;
            }
            if(i1 != 1){
                list2[i2++] = x;
            }
        }
        int a = robVal(list1);
        int b = robVal(list2);
        return Math.max(a, b);
    }

    public int robVal(int[] nums) {
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