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
  public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(new TreeNode(-99999));
                if(root==null) return lists;

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null) continue;
            if(curr.val == -99999){
                lists.add(list);
                
                if(!queue.isEmpty()){
                    queue.offer(new TreeNode(-99999));
                    list = new ArrayList<>();
                }
            } else {
                list.add(curr.val);
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
        }

        return lists;
    }
}
