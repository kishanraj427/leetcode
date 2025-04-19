// 6. Zigzag Conversion

/*  
16ms -> Beats 14.97%
Memory 45.71MB -> Beats 18.08%
*/

import java.util.*;
class Solution {
    public String convert(String s, int k) {
        List<List<Character>> store = new ArrayList<>();
        if(k == 1) return s;
        for(int i = 0; i < k; i++) 
            store.add(new ArrayList<>());
        int i = 0;
        boolean isAdd = true;
        for(char c : s.toCharArray()) {
            store.get(i).add(c);
            if(isAdd) {
                i++;
            } else {
                i--;
            }
            if(i >= k) {
                isAdd = false;
                i -= 2;
            }
            if(i < 0) {
                isAdd = true;
                i += 2;
            }
        }
        String st = "";
        for(int in = 0; in < k; in++) {
            for(char c : store.get(in)) {
                st += c;
            }
        }
        return st;
    }
}