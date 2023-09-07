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
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);
        return maxSum;
    }

    public int [] maxSumBSTHelper(TreeNode root) {
        if(root == null) {
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }

        int[] left = maxSumBSTHelper(root.left);
        int[] right = maxSumBSTHelper(root.right);

        if(left == null || right == null) {
            return null;
        }

        if(root.val <= left[1] || root.val >= right[0]) {
            return null;
        }

        int sum = left[2] + right[2] + root.val;

        maxSum = Math.max(sum, maxSum);
        return new int[]{Math.min(left[0],root.val), Math.max(right[1], root.val), sum};
    }
}