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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int prei=0, prej=preorder.length-1;
        int ini=0, inj=inorder.length-1;

        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);

        }

       TreeNode node = buildTreeRecursively(preorder, prei, prej, inorder, ini, inj, inorderIndexMap);

        return node;
    }

    private TreeNode buildTreeRecursively(int[] preorder, int prei, int prej, int[] inorder, int ini, int inj, Map<Integer, Integer> inorderIndexMap) {

        if(prei>prej || ini>inj) return null;

        TreeNode node = new TreeNode(preorder[prei]);

        int rootInorderIndex = inorderIndexMap.get(preorder[prei]);
        int sizeOfLeft = rootInorderIndex - ini;
        if(prei<prej){
            node.left = buildTreeRecursively(preorder, prei+1, prei + sizeOfLeft, inorder, ini, rootInorderIndex-1, inorderIndexMap);

            node.right = buildTreeRecursively(preorder, prei+sizeOfLeft+1, prej, inorder, rootInorderIndex+1, inj, inorderIndexMap);
        }

        return node;
    }
}
