// 49. Group Anagrams

/*  
Runtime 6ms -> Beats 98.04%
Memory 47.51MB -> Beats 95.43%
*/

class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lmax = 0, rmax = 0;
        int total = 0;
        while(l < r) {
            if(height[l] <= height[r]) {
                if(lmax > height[l]) total += lmax - height[l];
                else  lmax = height[l];
                l++;
            } else {
                if(rmax > height[r]) total += rmax - height[r];
                else  rmax = height[r];
                r--;
            }
        }   
        return total;
    }
}