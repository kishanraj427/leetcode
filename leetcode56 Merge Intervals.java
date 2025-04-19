// 56. Merge Intervals

/*  
8ms -> Beats 86.63%
Memory 46.62MB -> Beats 54.98%


*/

import java.util.*;

class Solution {
    class Pair {
        int a;
        int b;
        Pair() {
            a = 0;
            b = 0;
        }
        Pair(int x, int y) {
            a = x;
            b = y;
        } 
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(intervals[0][0], intervals[0][1]));
        for(int i = 1; i < intervals.length; i++) {
            Pair last = list.get(list.size()-1);
            if(last.b >= intervals[i][0]) {
                list.get(list.size()-1).b = last.b > intervals[i][1] ? last.b : intervals[i][1];
            } else {
                list.add(new Pair(intervals[i][0], intervals[i][1]));
            }
        }
        int[][] ans = new int[list.size()][2];
        int i = 0;
        for(Pair p : list) {
            ans[i][0] = p.a;
            ans[i][1] = p.b; 
            i++;
        }
        return ans; 
    }
}