// 22. Generate Parentheses

/* 
Runtime 1ms -> Beats 82.81%
Memory 43.16MB -> Beats 69.13%
*/

import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        return generate(n, 0, 0, "", new ArrayList<>());
    }
    List<String> generate(int n, int i, int j, String s, List<String> list) {
        if(i == n && i == j) {
                list.add(s);
                return list;
        }
        if(i >= j && i < n) {
            list = generate(n, i+1, j, s+"(", list);
        }
        if(j < i && j < n) {
            list = generate(n, i, j+1, s+")", list);
        }
        return list;
    }
}