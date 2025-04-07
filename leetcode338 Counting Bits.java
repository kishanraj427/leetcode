// 338. Counting Bits

/*  
0ms Beats -> 100%
Memory 41.16MB -> Beats 49.49%
*/

class Solution {
    public int[] countBits(int n) {
        int[] store = new int[n+1];
        for(int i = 0; i <= n; i++) {
            int count = 0;
            int num = i;
            while(num != 0) {
                if(num % 2 == 1) count++;
                num = num / 2;
            }   
            store[i] = count; 
        } 
        return store;
    }
}