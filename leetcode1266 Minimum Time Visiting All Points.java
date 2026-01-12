// 1266. Minimum Time Visiting All Points
/*  
29ms Beats -> 4.31%%
Memory 45.03MB -> Beats 15.50%%

*/

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int[] start = points[0];
        int count = 0;
        for(int index = 1; index < points.length; index++) {
            boolean reached = false;
            int[] next = points[index]; 
            while(!reached) {
                int a = next[0] - start[0];
                int b = next[1] - start[1]; 
                if(a > 0 && b > 0) {
                    start[0]++;
                    start[1]++;
                }
                else if(a > 0 && b == 0) {
                    start[0]++;
                }
                else if(a == 0 && b > 0) {
                    start[1]++;
                }
                else if(a < 0 && b < 0) {
                    start[0]--;
                    start[1]--;
                }
                else if(a < 0 && b == 0) {
                    start[0]--;
                }
                else if(a == 0 && b < 0) {
                    start[1]--;
                }
                // Opposite
                else if((a > 0 && b < 0)) {
                    if(abs(a) > abs(b)) {
                      start[0]++;
                    } 
                    else if(abs(a) < abs(b)) {
                      start[1]--;
                    } else {
                        start[0]++;
                        start[1]--;
                    }
                }
                else if(a < 0 && b > 0) {
                    if(abs(a) > abs(b)) {
                      start[0]--;
                    } 
                    else if(abs(a) < abs(b)) {
                      start[1]++;
                    } else {
                        start[0]--;
                        start[1]++;
                    }
                } else {
                    break;
                }
                count++;
                
            }
            start = next;
        }
        return count;
    }

    public int abs(int a) {
        if(a < 0) return -a;
        return a;
    }
}

