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
    class CustomNode{
        TreeNode node;
        int column;
        int row;
        CustomNode(TreeNode node, int column, int row){
            this.node = node;
            this.column = column;
            this.row = row;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<CustomNode> queue = new LinkedList<>();
        queue.offer(new CustomNode(root, 0, 0));

        while(!queue.isEmpty()){
            CustomNode curr = queue.poll();
            TreeNode currNode = curr.node;
            int currColumn = curr.column;
            int currRow = curr.row;

            if(!map.containsKey(currColumn)){
                map.put(currColumn, new ArrayList<>());
            }
            map.get(currColumn).add(currNode.val);

            if(currNode.left != null){
                queue.offer(new CustomNode(currNode.left, currColumn-1, currRow+1));
            }
            if(currNode.right != null){
                queue.offer(new CustomNode(currNode.right, currColumn+1, currRow+1));
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for(var list : map.values()){
            result.add(list);
        }
        return result;
    }
}