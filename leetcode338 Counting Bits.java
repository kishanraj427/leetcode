// 338. Counting Bits

/*  
3ms Beats -> 34.53%
Memory 46.68MB -> Beats 67.43%
*/

import java.util.*;
class Solution {
    public int[] countBits(int n) {
        int[] store = new int[n+1];
        Arrays.fill(store, -1);
        for(int i = 0; i <= n; i++) {
            int count = 0;
            int num = i;
            while(num != 0) {
                if(store[num] == -1) {
                    if(num % 2 == 1) count++;
                    num = num / 2;
                } else {
                    count += store[num];
                    break;
                }
            }   
            store[i] = count; 
        } 
        return store;
    }
}