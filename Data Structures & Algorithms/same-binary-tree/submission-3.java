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
    public boolean solve(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val != root2.val) return false;

        boolean checkLeft = solve(root1.left, root2.left);
        boolean checkRight = solve(root1.right, root2.right);
        return checkLeft && checkRight; 
    }
    public void solveString(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append("0,");
            return;
        }
        solveString(node.left, sb);
        sb.append(node.val+",");
        solveString(node.right, sb);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        StringBuilder sb1 = new StringBuilder();
        solveString(p, sb1);
        StringBuilder sb2 = new StringBuilder();
        solveString(q, sb2);

        if(sb1.length() != sb2.length()) return false;
        for(int i=0 ; i<sb1.length() ; i++){
            if(sb1.charAt(i) != sb2.charAt(i)){
                return false;
            }
        }
        return true;

        // return solve(p, q);

        // BFS
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.offer(p);
        // queue.offer(q);
        // while(!queue.isEmpty()){
        //     TreeNode first = queue.poll();
        //     TreeNode second = queue.poll();

        //     if(first==null && second==null) continue;
        //     if(first==null || second==null) return false;
        //     if(first.val != second.val) return false;
            
        //     queue.offer(first.left);
        //     queue.offer(second.left);

        //     queue.offer(first.right);
        //     queue.offer(second.right);
        // }
        // return true;
    }
}
