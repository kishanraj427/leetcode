// 11. Container With Most Water

/*  
5ms Beats -> 74.76%%
Memory 57.81MB -> Beats 64.60%%

*/

class Solution {
    public int maxArea(int[] height) {
        int n = height.length-1;
        int i = 0;
        int max = 0;
        while(i < n) {
            int l;
            if(height[i] < height[n]) {
                l = height[i];
                i++;
            } else {
                l = height[n];
                n--;
            }
            max = Math.max(max, l * (n-i+1));
        }
        return max;
    }
}