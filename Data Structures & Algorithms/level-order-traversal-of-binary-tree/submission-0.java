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
    if (root == null) return lists;
    
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode sentinel = new TreeNode(-99999);
    queue.offer(root);
    queue.offer(sentinel);
    List<Integer> list = new ArrayList<>();

    while (!queue.isEmpty()) {
        TreeNode curr = queue.poll();
        if (curr == sentinel) {
            lists.add(new ArrayList<>(list));
            list.clear();
            // Only add sentinel if there are more nodes to process
            if (!queue.isEmpty()) {
                queue.offer(sentinel);
            }
        } else {
            list.add(curr.val);
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
    }
    return lists;
}
}
