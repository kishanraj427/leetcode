// 914. X of a Kind in a Deck of Cards

/*  
11ms -> Beats 58.53%
Memory 45.48MB -> Beats 61.68%
*/

import java.util.*;

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
    Map<Integer, Integer> count = new HashMap<>();
    int res = 0;
    for (int i : deck) count.put(i, count.getOrDefault(i, 0) + 1);
    for (int i : count.values()) res = gcd(i, res);
    return res > 1;
}

public int gcd(int a, int b) {
    return b > 0 ? gcd(b, a % b) : a;
}
}