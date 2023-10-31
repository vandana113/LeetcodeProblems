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
        // O(1) space
        
        TreeNode curr = root;

        while(curr!=null) {
            if(curr.left == null) {
                curr = curr.right;
            } else {
                TreeNode rightMost = curr.left;

                while(rightMost.right!=null){
                    rightMost = rightMost.right;
                }


                rightMost.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
        }
    }
}