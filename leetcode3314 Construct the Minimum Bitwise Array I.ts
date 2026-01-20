// 3314. Construct the Minimum Bitwise Array I

/*  
1ms Beats -> 86.67%
Memory 59.23MB -> Beats 20.00%

*/

function minBitwiseArray(nums: number[]): number[] {
    const ans: number[] = [];

    for (const num of nums) {
        if (num % 2 === 0) {
            // Even numbers cannot be formed by x | (x + 1)
            ans.push(-1);
        } else {
            // Count trailing ones
            let trailingOnes = 0;
            let temp = num;
            while ((temp & 1) === 1) {
                trailingOnes++;
                temp >>= 1;
            }

            // We subtract 2^(trailingOnes - 1) to turn the highest trailing 1 into a 0
            // Example: num = 23 (10111), trailingOnes = 3. 
            // We want x = 19 (10011). 
            // 23 - (1 << 2) = 23 - 4 = 19.
            ans.push(num - (1 << (trailingOnes - 1)));
        }
    }

    return ans;
};
