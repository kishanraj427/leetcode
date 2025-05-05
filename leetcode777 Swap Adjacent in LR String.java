// 777. Swap Adjacent in LR String

/*  
7ms -> Beats 44.78%
Memory 44.81MB -> Beats 19.78%
*/

class Solution {
    public boolean canTransform(String start, String end) {
        // Unequal position
       if (!start.replace("X", "").equals(end.replace("X", ""))) {
            return false;
        }

        int n = start.length();
        int i = 0, j = 0;

        while (i < n && j < n) {
            while (i < n && start.charAt(i) == 'X') i++;
            while (j < n && end.charAt(j) == 'X') j++;

            if (i == n && j == n) return true;
            if (i == n || j == n) return false;

            // After skipping X unequal elements
            if (start.charAt(i) != end.charAt(j)) return false;

            if (start.charAt(i) == 'L' &&  j > i) return false; // for checking l should always move left
            if (start.charAt(i) == 'R' &&  j < i) return false;//for checking R should always move right

            i++;
            j++;
        }

        return true;
    }
}