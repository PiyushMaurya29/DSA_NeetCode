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
class BSTIterator {

    public void solveInorder(TreeNode root, List<Integer> inorderList){
        if(root == null) return;
        solveInorder(root.left, inorderList);
        inorderList.add(root.val);
        solveInorder(root.right, inorderList);
    }

    List<Integer> inorderList;
    int index;
    public BSTIterator(TreeNode root) {
        inorderList = new ArrayList<>();
        solveInorder(root, inorderList);
        index = 0;
    }
    
    public int next() {
        return inorderList.get(index++);
    }
    
    public boolean hasNext() {
        return index < inorderList.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */