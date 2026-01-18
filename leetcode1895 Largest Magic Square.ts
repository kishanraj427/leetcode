// 1895. Largest Magic Square

/*  
17ms Beats -> 60.00%%
Memory 59.16MB -> Beats 80.00%%

*/

function largestMagicSquare(grid: number[][]): number {
    const R = grid.length;
    const C = grid[0].length;
    
    // 1. Build Prefix Sum Arrays for O(1) range sum lookups
    // rowPre[i][j] stores sum of row i from column 0 to j-1
    const rowPre: number[][] = Array.from({ length: R }, () => new Array(C + 1).fill(0));
    // colPre[i][j] stores sum of column j from row 0 to i-1
    const colPre: number[][] = Array.from({ length: R + 1 }, () => new Array(C).fill(0));

    for (let r = 0; r < R; r++) {
        for (let c = 0; c < C; c++) {
            rowPre[r][c + 1] = rowPre[r][c] + grid[r][c];
            colPre[r + 1][c] = colPre[r][c] + grid[r][c];
        }
    }

    // 2. Iterate possible sizes k from largest possible down to 2
    // The first one we find is guaranteed to be the largest.
    const maxPoss = Math.min(R, C);
    for (let k = maxPoss; k > 1; k--) {
        // Iterate through every possible top-left corner (r, c)
        for (let r = 0; r <= R - k; r++) {
            for (let c = 0; c <= C - k; c++) {
                if (checkMagic(grid, rowPre, colPre, r, c, k)) {
                    return k;
                }
            }
        }
    }

    return 1; // A single cell is always a magic square of size 1
};

function checkMagic(
    grid: number[][], 
    rowPre: number[][], 
    colPre: number[][], 
    r: number, 
    c: number, 
    k: number
): boolean {
    // 1. Calculate Diagonal Sums (Must be done manually)
    let d1 = 0, d2 = 0;
    for (let i = 0; i < k; i++) {
        d1 += grid[r + i][c + i];           // Main diagonal
        d2 += grid[r + i][c + k - 1 - i];   // Anti-diagonal
    }

    if (d1 !== d2) return false;

    // The target sum for all rows and cols must be d1
    const target = d1;

    // 2. Check Rows using Prefix Sums
    for (let i = 0; i < k; i++) {
        const currentRowSum = rowPre[r + i][c + k] - rowPre[r + i][c];
        if (currentRowSum !== target) return false;
    }

    // 3. Check Columns using Prefix Sums
    for (let j = 0; j < k; j++) {
        const currentColSum = colPre[r + k][c + j] - colPre[r][c + j];
        if (currentColSum !== target) return false;
    }

    return true;
}
