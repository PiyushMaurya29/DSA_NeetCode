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
    public int dfsHeight(TreeNode root){
        if(root == null) return 0;
        int leftHeight = dfsHeight(root.left);
        int rightHeight = dfsHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public void solveDFS(TreeNode root, int[] result){
        if(root == null) return;
        int leftHeight = dfsHeight(root.left);
        int rightHeight = dfsHeight(root.right);
        result[0] = Math.max(result[0], leftHeight+rightHeight);
        solveDFS(root.left, result);
        solveDFS(root.right, result);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int[] result = {0};
        solveDFS(root, result);
        return result[0];
    }
}
