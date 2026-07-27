// 1464. Maximum Product of Two Elements in an Array

/*  
1ms -> Beats 66.20%
Memory 44.56MB -> Beats 60.68%
*/

class Solution {
    public int maxProduct(int[] nums) {
        int i = 0, j = nums.length-1;
        int max = 0;
        while(i < j) {
            int cal = (nums[i]-1) * (nums[j]-1);
            if(cal > max) max = cal;
            if(nums[i] > nums[j]) j--;
            else i++; 
        }   
        return max;
    }
}
