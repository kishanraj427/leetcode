// 1326. Minimum Number of Taps to Open to Water a Garden

/*  
4ms -> Beats 92.79%
Memory 44.51MB -> Beats 52.48%
*/

class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] tap = new int[n+1];
        for(int i=0; i<=n; i++) {
            if(ranges[i] == 0) {
                continue;
            }
            int left = Math.max(0, i-ranges[i]);
            tap[left] = Math.max(tap[left], i+ranges[i]);
        }

        int curEnd=0, farthest=0, total=0;
        for(int i=0; i<n+1 && curEnd<n; curEnd=farthest) {
            total++;
            while(i<n+1 && i<=curEnd) {
                farthest = Math.max(farthest, tap[i++]);
            }
            if(curEnd == farthest) {
                return -1;
            }
        }
        return total;
    }
}