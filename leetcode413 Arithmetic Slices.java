// 413. Arithmetic Slices

/*  
0ms Beats -> 100%
Memory 41.36MB -> Beats 78.92%

*/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int[] dp = new int[n]; 
        if (nums[2]-nums[1] == nums[1]-nums[0]) dp[2] = 1; 
        int result = dp[2];
        for (int i = 3; i < n; ++i) {
            if (nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) 
                dp[i] = dp[i-1] + 1;
            result += dp[i]; 
        }
        return result;
        // return doWork(nums, nums.length-1,  0, list);
    }

    // int doWork(int[] nums, int n, int diff, List<Integer> list) {
    //     if(n < 0) return 0;
    //     int take  = 0, notTake  = 0;
    //     if(list.size() == 1) {
    //         diff = list.get(0) - nums[n];
    //     }
    //     if(list.size() <= 1 || diff == list.get(0) - nums[n]){
    //         list.add(0, nums[n]);
    //         if(list.size() >= 3) take++;
    //         take += doWork(nums, n-1, diff, list);
    //         list.remove(0);
    //     }
    //     if(list.isEmpty())
    //         notTake = doWork(nums, n-1, diff, list);
    //     return take + notTake;
    // }

}