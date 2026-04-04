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
    public int kthSmallest(TreeNode r, int k) {
        int[] res = {-1};
        int[] K = {k};
        kthSmallest0(r, K, res);
        return res[0];
    }

    private void kthSmallest0(TreeNode r, int[] k, int[] res) {
        if(k[0]==0) return;
        if(r==null) return;

        kthSmallest0(r.left, k, res);

        k[0]--;
        if(k[0]==0) res[0] = r.val;

        kthSmallest0(r.right, k, res);

    }
}
