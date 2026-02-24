// 1146. Snapshot Array

/*  
0ms -> Beats 100%
Memory 43.90MB -> Beats 41.87%
*/

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        // Start the DFS with an initial sum of 0
        return dfs(root, 0);      
    }

    private int dfs(TreeNode root, int currentSum) {
        if (root == null) {
            return 0;
        }
        
        // Shift the current sum left by 1 (multiply by 2) and add the current node's bit.
        // E.g., if currentSum is 3 (binary 11) and root.val is 0,
        // (3 << 1) becomes 6 (binary 110). 6 | 0 remains 6.
        currentSum = (currentSum << 1) | root.val;
        
        // If we reach a leaf node, return the accumulated sum for this path
        if (root.left == null && root.right == null) {
            return currentSum;
        }
        
        // Recurse down the left and right children and add their results together
        return dfs(root.left, currentSum) + dfs(root.right, currentSum); 
    }
}
