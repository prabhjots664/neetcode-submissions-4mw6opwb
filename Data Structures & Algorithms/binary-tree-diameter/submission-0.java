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
    public int diameterOfBinaryTree(TreeNode r) {
        if(r==null) return 0;
        int d1 = height(r.left) + height(r.right);
        int d2 = diameterOfBinaryTree(r.left);
        int d3 = diameterOfBinaryTree(r.right);
        int d4 = Math.max(d1,d2);
        return Math.max(d3,d4);

    }

    int height(TreeNode r){
        if(r==null) return 0;

        int a = height(r.left);
        int b = height(r.right);

        return 1 + Math.max(a,b);
    }
}