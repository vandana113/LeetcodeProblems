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
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        int BOTH_PENDING = 2, ONE_DONE = 1, BOTH_DONE = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        stack.push(new Pair<>(root, BOTH_PENDING));

        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode curr = pair.getKey();
            int state = pair.getValue();

            if(curr.left == null && curr.right == null) {
                result.add(curr.val);
                continue;
            }

            if(state == BOTH_PENDING) {
                stack.push(new Pair<>(curr, state - 1));
                if(curr.left!=null) {
                    stack.push(new Pair<>(curr.left, BOTH_PENDING));
                }
            } else if(state == ONE_DONE) {
                stack.push(new Pair<>(curr, state - 1));
                if(curr.right!=null) {
                    stack.push(new Pair<>(curr.right, BOTH_PENDING));
                }
            } else {
                result.add(curr.val);
            }
        }
        return result;
    }
}