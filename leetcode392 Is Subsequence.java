// 392. Is Subsequence

/*  
1ms Beats -> 93.38%
Memory 41.56MB -> Beats54.99%

*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        if(s.isEmpty()) return true;
        for(char c : t.toCharArray()) {
            if(c == s.charAt(i)) {
                i++;
            }
            if(i == s.length()) {
                return true;
            }
        }
        return i == s.length();
    }
}