// 3047. Find the Largest Area of Square Inside Two Rectangles

/*  
194ms Beats -> -%%
Memory 63.18MB -> Beats 33.33%%

*/

function largestSquareArea(bottomLeft: number[][], topRight: number[][]): number {
    let maxSide = 0;
    const n = bottomLeft.length;

    // Iterate through every unique pair of rectangles
    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            
            // 1. Calculate the intersection boundaries
            // Left boundary is the rightmost of the two left edges
            const minX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
            
            // Bottom boundary is the highest of the two bottom edges
            const minY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
            
            // Right boundary is the leftmost of the two right edges
            const maxX = Math.min(topRight[i][0], topRight[j][0]);
            
            // Top boundary is the lowest of the two top edges
            const maxY = Math.min(topRight[i][1], topRight[j][1]);

            // 2. Calculate width and height
            const width = maxX - minX;
            const height = maxY - minY;

            // 3. If there is a valid overlap (both dimensions positive)
            if (width > 0 && height > 0) {
                // The largest square is limited by the shorter side of the intersection
                const side = Math.min(width, height);
                
                if (side > maxSide) {
                    maxSide = side;
                }
            }
        }
    }

    // Return the area (side * side)
    return maxSide * maxSide;
};
