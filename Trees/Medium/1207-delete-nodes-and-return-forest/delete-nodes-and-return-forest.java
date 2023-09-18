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
    List<TreeNode> forest = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> delNodes = new HashSet<>();
        for(int i=0; i<to_delete.length; i++) {
            delNodes.add(to_delete[i]);
        }
        delNodesHelper(root, delNodes);
        if(!delNodes.contains(root.val)) {
            forest.add(root);
        }
        return forest;
    }  

    public TreeNode delNodesHelper(TreeNode root, HashSet<Integer> delNodes) {
        if(root == null) {
            return null;
        }
        root.left = delNodesHelper(root.left, delNodes);
        root.right = delNodesHelper(root.right, delNodes);
        if(delNodes.contains(root.val)) {
            if(root.left!=null){
                forest.add(root.left);
            } 
            if(root.right!=null){
                forest.add(root.right);
            }     
            return null;
        }
        return root;
    }
}