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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Stack<Pair<TreeNode,Integer>> stack = new Stack<>(); 
        stack.push(new Pair<>(root,1));     
        int maxDepth = 0;
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode curr = pair.getKey();
            int depth = pair.getValue();
            maxDepth = Math.max(depth, maxDepth);
            if(curr.left!=null) {
                stack.push(new Pair<>(curr.left, depth+1));
            }
            if(curr.right!=null) {
                stack.push(new Pair<>(curr.right, depth+1));
            }
        }
        return maxDepth;     
    }
}