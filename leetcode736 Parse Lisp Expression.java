// 736. Parse Lisp Expression

/*  
5ms Beats -> 59.06%
Memory 44.56MB -> Beats 26.17%
*/

import java.util.*;

class Solution {
    public int evaluate(String expression) {
        return eval(expression, new HashMap<>());
    }
    private int eval(String exp, Map<String, Integer> parent) {
        if (exp.charAt(0) != '(') {
            // just a number or a symbol
            if (Character.isDigit(exp.charAt(0)) || exp.charAt(0) == '-')
                return Integer.parseInt(exp);
            return parent.get(exp);
        }
        // create a new scope, add add all the previous values to it
        Map<String, Integer> map = new HashMap<>();
        map.putAll(parent);
        List<String> tokens = parse(exp.substring(exp.charAt(1) == 'm' ? 6 : 5, exp.length() - 1));
        if (exp.startsWith("(a")) { // add
            return eval(tokens.get(0), map) + eval(tokens.get(1), map);
        } else if (exp.startsWith("(m")) { // mult
            return eval(tokens.get(0), map) * eval(tokens.get(1), map);
        } else { // let
            for (int i = 0; i < tokens.size() - 2; i += 2)
                map.put(tokens.get(i), eval(tokens.get(i + 1), map));
            return eval(tokens.get(tokens.size() - 1), map);
        }
    }
    private List<String> parse(String str) {
        // seperate the values between two parentheses
        List<String> res = new ArrayList<>();
        int par = 0;
        StringBuilder sb = new StringBuilder();
        for (char c: str.toCharArray()) {
            if (c == '(') par++;
            if (c == ')') par--;
            if (par == 0 && c == ' ') {
                res.add(new String(sb));
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) res.add(new String(sb));
        return res;
    }
}