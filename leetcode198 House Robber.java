// 198. House Robber

/*  
0ms Beats -> 100%
Memory 41.26MB -> Beats 34.32%

*/

import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> store = new ArrayList<>();
        doWork(s, result, store, 0);
        return result;
    }

    void doWork(String s, List<List<String>> result, List<String> store, int ind){
        if(ind == s.length()) {
            result.add(new ArrayList<>(store));
            return;
        }
        for(int i = ind; i < s.length(); i++) {
            if(isPalindrome(s, ind, i)) {
                store.add(s.substring(ind, i+1));
                doWork(s, result, store, i+1);
                store.remove(store.size()-1);
            }
        }
    }

     boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}