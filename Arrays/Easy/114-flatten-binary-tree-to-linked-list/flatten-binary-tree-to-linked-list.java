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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        int START = 1, END = 2;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        stack.push(new Pair<>(root, START));

        TreeNode tail = null;
        TreeNode rightNode = null;

        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode curr = pair.getKey();
            int state = pair.getValue();

            if(curr.left == null && curr.right == null) {
                tail = curr;
            }

            if(state == START) {
                if(curr.left != null){
                    stack.push(new Pair<>(curr, END));
                    stack.push(new Pair<>(curr.left, START));
                } else if(curr.right != null) {
                    stack.push(new Pair<>(curr.right, START));
                }
            } else {
                if(tail!=null) {
                    tail.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;
                    rightNode = tail.right;
                }
                
                if(rightNode!=null) {
                    stack.push(new Pair<>(rightNode, START));
                }
            }
        }
        
    }
}