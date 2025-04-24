// 1463. Cherry Pickup II

/*  
26ms -> Beats 56.44%
Memory 45.52MB -> Beats 85.76%
*/


import java.util.*;

class Solution {
    public int cherryPickup(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[][][] dp = new int[r+1][c+1][c+1];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                Arrays.fill(dp[i][j], -1);
            }   
        }
        return startPicking(0, 0, c-1, r, c, grid, dp);
    }

    int startPicking(int i, int j1, int j2, int r, int c, int[][] grid, int[][][] dp) {
        if(j1 < 0 || j2 < 0 || j1 >= c || j2 >= c) return (int) -1e8;
        if(i == r-1) {
            if(j1 == j2) return grid[i][j1];
            return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        int max = (int)-1e8;
        for(int nI = -1; nI < 2; nI++) {
            for(int nJ = -1; nJ < 2; nJ++) {
                int val = 0;
                if(j1 == j2) val = grid[i][j1];
                else val = grid[i][j1] + grid[i][j2];
                val += startPicking(i+1, j1 + nI, j2 + nJ, r, c, grid, dp);
                max = Math.max(max, val);
            }   
        }
        return dp[i][j1][j2] = max;
    }
}