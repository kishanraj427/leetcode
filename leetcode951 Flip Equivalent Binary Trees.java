// 951. Flip Equivalent Binary Trees

/*  
0ms Beats -> 100%
Memory 41.61MB -> Beats 30.63%
*/

class TreeNode {
    int val;
    TreeNode left, right;
}

class Solution {
    public boolean flipEquiv(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) return r1 == r2;
        return r1.val == r2.val &&
               ((flipEquiv(r1.left, r2.left) && flipEquiv(r1.right, r2.right)) || 
               (flipEquiv(r1.left, r2.right) && flipEquiv(r1.right, r2.left)));
    }
}