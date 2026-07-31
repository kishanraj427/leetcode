// 3016. Minimum Number of Pushes to Type Word II

/*
10ms -> Beats 66.76%
Memory 48.17MB -> Beats 32.08%
*/

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        Arrays.sort(freq);

        int count = 0;
        int mul = 1;
        // freq is sorted ascending; iterate from the end (highest freq first)
        for (int i = 25, seen = 0; i >= 0; i--, seen++) {
            if (freq[i] == 0) break; // no more letters used
            if (seen > 0 && seen % 8 == 0) mul++;
            count += freq[i] * mul;
        }

        return count;
    }
}
