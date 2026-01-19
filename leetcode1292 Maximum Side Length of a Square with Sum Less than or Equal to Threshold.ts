// 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold

/*  
13ms Beats -> 83.33%%
Memory 63.44MB -> Beats 66.67%%
*/

function maxSideLength(mat: number[][], threshold: number): number {
    const m = mat.length;
    const n = mat[0].length;
    
    // Create a (m+1) x (n+1) matrix for prefix sums to handle 0-based index boundaries easily
    const dp: number[][] = Array.from({ length: m + 1 }, () => new Array(n + 1).fill(0));

    // 1. Build the 2D Prefix Sum Array
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            dp[i][j] = mat[i - 1][j - 1] 
                     + dp[i - 1][j] 
                     + dp[i][j - 1] 
                     - dp[i - 1][j - 1];
        }
    }

    let maxLen = 0;

    // 2. Iterate through every cell as a potential bottom-right corner
    for (let i = 1; i <= m; i++) {
        for (let j = 1; j <= n; j++) {
            // We only care if we can find a square bigger than what we already found
            const currentSide = maxLen + 1;

            // Check if a square of size `currentSide` ending at (i, j) is within bounds
            if (i >= currentSide && j >= currentSide) {
                const r1 = i - currentSide;
                const c1 = j - currentSide;

                // Calculate sum of the square defined by top-left (r1, c1) and bottom-right (i, j)
                // Note: r1 and c1 correspond to indices in the DP array directly 
                // because DP is padded by 1.
                const currentSum = dp[i][j] 
                                 - dp[r1][j] 
                                 - dp[i][c1] 
                                 + dp[r1][c1];

                if (currentSum <= threshold) {
                    maxLen++;
                }
            }
        }
    }

    return maxLen;
}
