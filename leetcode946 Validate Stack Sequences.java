// 946. Validate Stack Sequences

/*  
1ms Beats -> 95.71%
Memory 44.14MB -> Beats 87.84%

*/

import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        List<Integer> list = new ArrayList<>();
        int i = 0, n = popped.length;
        for(int x : pushed) {
            list.add(x);
            while(i < n && !list.isEmpty() && list.get(list.size()-1) == popped[i]) {
                list.remove(list.size()-1);
                i++;
            }
        } 
        return list.isEmpty();
    }
}