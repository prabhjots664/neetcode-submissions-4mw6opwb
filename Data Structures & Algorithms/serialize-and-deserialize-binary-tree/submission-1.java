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

public class Codec {

    void dfsSerialize(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("N,");
            return;
        } 
        sb.append(Integer.toString(root.val));
        sb.append(",");
        
        dfsSerialize(root.left, sb);
        dfsSerialize(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }
    
    TreeNode dfsDeserialize(String[] vals, int[] i){
        
        if(vals[i[0]].equals("N")){
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        
        TreeNode left = dfsDeserialize(vals, i);
        TreeNode right = dfsDeserialize(vals, i);
        node.left=left;
        node.right=right;
        
        return node;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String str) {
        int[] i = {0};
        String[] vals = str.split(",");
        return dfsDeserialize(vals, i);
    }
}
