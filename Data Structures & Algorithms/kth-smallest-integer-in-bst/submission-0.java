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
    private void inorderBST(TreeNode r, List<Integer> list) {
        if(r==null) return;

        inorderBST(r.left, list);
        list.add(r.val);
        inorderBST(r.right, list);
    }

    public int kthSmallest(TreeNode r, int k) {

        List<Integer> list = new ArrayList<>();
        inorderBST(r, list);
        return list.get(k-1);
        
    }
}
