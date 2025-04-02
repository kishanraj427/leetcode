// 85. Maximal Rectangle

/*  
Runtime 15ms -> Beats 73.02%
Memory 46.82MB -> Beats 38.73%
*/

import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] store = new int[n];
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1')
                    store[j]++;
                else store[j] = 0;
            }   
            max = Math.max(getMax(store), max);
        }
        return max;
    }

    int getMax(int[] histo) {
        int n = histo.length;
        int max = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i <= n; i++) {
            while(!st.isEmpty() && (i == n || histo[i] <= histo[st.peek()])) {
                int height = histo[st.peek()];
                st.pop();
                int width = i;
                if(!st.isEmpty()) width = i - st.peek() - 1;
                max = Math.max(max, height * width);
            }
            st.add(i);
        }
        return max;
    }

}