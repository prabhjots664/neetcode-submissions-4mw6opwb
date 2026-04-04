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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);q.offer(new TreeNode(-111));
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){
                break;
            }
            if(!q.isEmpty() && q.peek().val==-111){
                res.add(node.val);
            }
            if(node.left!=null)  q.offer(node.left);
            if(node.right!=null)  q.offer(node.right);

            if(node.val==-111){
                if(!q.isEmpty()){
                    q.offer(node);
                }
            }
        }
        return res;
    }
}








