// 1356. Sort Integers by The Number of 1 Bits

/*  
4ms Beats -> 100%%
Memory 54.76MB -> Beats 78.95%%

*/



function sortByBits(arr: number[]): number[] {
    // Helper function to count the number of 1s (set bits)
    const countBits = (num: number): number => {
        let count = 0;
        while (num > 0) {
            num &= (num - 1); // Clears the lowest set bit
            count++;
        }
        return count;
    };

    // Sort using the custom comparator
    return arr.sort((a, b) => {
        const bitsA = countBits(a);
        const bitsB = countBits(b);
        
        // Secondary condition: if bit counts are equal, sort by integer value
        if (bitsA === bitsB) {
            return a - b; 
        }
        
        // Primary condition: sort by bit count
        return bitsA - bitsB;
    });
}
