// 62. Unique Paths

/*  
Runtime 0ms -> Beats 100.00%
Memory 40.16MB -> Beats 91.77%
*/

class Solution {
    public int climbStairs(int n) {
        int prev1 = 1;
        int prev2 = 1;
        for(int i = 2; i <= n; i++) {
            int a = prev1;
            int b = prev2;
            prev1 = prev2;
            prev2 = a+b;
        }
        return prev2;
    }
}