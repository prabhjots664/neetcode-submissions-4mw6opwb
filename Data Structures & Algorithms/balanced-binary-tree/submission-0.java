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
    public boolean isBalanced(TreeNode r) {
        if(r==null) return true;
        boolean a = Math.abs(height(r.left)-height(r.right)) <= 1;
        boolean b = isBalanced(r.left);
        boolean c = isBalanced(r.right);

        return a&b&c;
    }

    int height(TreeNode r){
        if(r==null){
            return 0;
        }

        return 1 + Math.max(height(r.left),height(r.right));
    }
}