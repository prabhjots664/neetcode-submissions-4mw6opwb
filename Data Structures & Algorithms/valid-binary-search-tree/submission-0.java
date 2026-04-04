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
    public boolean isValidBST(TreeNode r) {

        List<Integer> list = new ArrayList<>();
        inorderBST(r, list);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i-1)>=list.get(i)){
                return false;
            }
        }
        return true;
    }

    private void inorderBST(TreeNode r, List<Integer> list) {

        if(r==null) return;

        inorderBST(r.left, list);

        list.add(r.val);

        inorderBST(r.right, list);

    }
}
