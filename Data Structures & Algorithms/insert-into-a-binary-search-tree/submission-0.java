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
    public void solve(TreeNode root, TreeNode node){
        if(root == null) return;
        if(root.val>node.val && root.left==null){
            root.left = node;
            return;
        }
        if(root.val<node.val && root.right==null){
            root.right = node;
            return;
        }
        if(root.val > node.val){
            solve(root.left, node);
        }
        solve(root.right, node);
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        solve(root, node);
        return root;
    }
}