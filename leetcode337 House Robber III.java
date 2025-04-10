// 337. House Robber III

/*  
2ms -> Beats 41.17%
Memory 45.24MB -> Beats 24.96%
*/


import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     @SuppressWarnings("unused")
     TreeNode() {}
     @SuppressWarnings("unused")
     TreeNode(int val) { this.val = val; }
     @SuppressWarnings("unused")
     TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    public int rob(TreeNode root) {
        return getMax(root, new HashMap<>());
    }

    int getMax(TreeNode root, Map<TreeNode, Integer> map) {
        if(root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int take = root.val;
        int lt = 0, rt = 0;
        if(root.left != null) {
            int a = getMax(root.left.left, map);
            int b = getMax(root.left.right, map);
            lt = a + b;
        }
        if(root.right != null) {
            int a = getMax(root.right.left, map);
            int b = getMax(root.right.right, map);
            rt = a + b;
        }
        take += lt + rt;

        int ln = getMax(root.left, map);
        int rn = getMax(root.right, map);
        int notTake = ln + rn;
        int ans = Math.max(take, notTake);
        map.put(root, ans);
        return ans;
    }
}