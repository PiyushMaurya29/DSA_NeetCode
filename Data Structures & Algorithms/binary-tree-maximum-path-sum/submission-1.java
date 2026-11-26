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
    int result;
    public int solve(TreeNode root){
        if(root == null) return 0;
        int leftSum = solve(root.left);
        int rightSum = solve(root.right);

        result = Math.max(result, root.val+leftSum+rightSum);

        return root.val + Math.max(leftSum, rightSum);
    }
    public int maxPathSum(TreeNode root) {
        result = 0;
        solve(root);
        return result;
    }
}
