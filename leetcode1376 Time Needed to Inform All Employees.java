// 1376. Time Needed to Inform All Employees

/*  
45ms Beats -> 91.88%
Memory 62.27MB -> Beats 66.67%
*/

import java.util.*;

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) if (manager[i] != -1) graph[manager[i]].add(i);
        return dfs(graph, headID, informTime);
    }
    private int dfs(List<Integer>[] graph, int u, int[] informTime) {
        int ans = 0;
        for (int v : graph[u])
            ans = Math.max(ans, dfs(graph, v, informTime));
        return ans + informTime[u];
    }
}