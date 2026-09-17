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
    public int bfsHeight(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            while(levelSize-- > 0){
                TreeNode curr = queue.poll();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            level++;
        }
        return level;
    }
    public void solveDFS(TreeNode root, int[] result){
        if(root == null) return;
        // int leftHeight = dfsHeight(root.left);
        // int rightHeight = dfsHeight(root.right);
        int leftHeight = bfsHeight(root.left);
        int rightHeight = bfsHeight(root.right);
        result[0] = Math.max(result[0], leftHeight+rightHeight);
        solveDFS(root.left, result);
        solveDFS(root.right, result);
    }

    public int solveBFS(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        int result = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            // int leftHeight = dfsHeight(curr.left);
            // int rightHeight = dfsHeight(curr.right);
            int leftHeight = bfsHeight(curr.left);
            int rightHeight = bfsHeight(curr.right);
            result = Math.max(result, leftHeight+rightHeight);

            if(curr.left != null) queue.offer(curr.left);
            if(curr.right != null) queue.offer(curr.right);
        }
        return result;
    }

    public int solve(TreeNode root, int[] result){
        if(root == null) return 0;
        int leftHeight = solve(root.left, result);
        int rightHeight = solve(root.right, result);
        result[0] = Math.max(result[0], leftHeight+rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = {0};
        solve(root, result);
        return result[0];


        // return solveBFS(root);


        // if(root == null) return 0;
        // int[] result = {0};
        // solveDFS(root, result);
        // return result[0];
    }
}
