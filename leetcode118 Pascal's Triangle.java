// 118. Pascal's Triangle

/*  
Runtime 1ms -> Beats 84.73%
Memory 42.12MB -> Beats 40.01%
*/

import java.util.*;

class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> store = new ArrayList<>();
        store.add(1);
        ans.add(store);
        for(int i = 1; i < n; i++) {
            List<Integer> data = new ArrayList<>();    
            data.add(1);
            for(int j = 1; j < store.size(); j++) {
                data.add(store.get(j-1) + store.get(j));
            }   
            data.add(1);
            store = data;
            ans.add(store);
        }
        return ans;
    }
}