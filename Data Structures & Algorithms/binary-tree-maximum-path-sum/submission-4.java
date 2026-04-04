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
    int globalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return globalMax;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        // Only include positive gains from both sides
        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        // Price to start a new path where node is the highest ancestor
        int priceNewPath = node.val + leftGain + rightGain;

        // Update global if new path is better
        globalMax = Math.max(globalMax, priceNewPath);

        // For recursion: return max one-side gain to parent
        return node.val + Math.max(leftGain, rightGain);
    }
}



