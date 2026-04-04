/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        int[] res = new int[5];//0 is count
        res[0] = 0; 
        helper(root, res, -10000);

        return res[0];
    }

    void helper(TreeNode r, int[] res, int maxInThisPath){
        if(r==null){
            return;
        }
        if(r.val >= maxInThisPath){
            maxInThisPath = r.val;
            res[0]++;
        }

        helper(r.left, res, maxInThisPath);

        helper(r.right, res, maxInThisPath);
    }


}
