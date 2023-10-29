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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagOrder = new ArrayList<>();
        if(root == null) {
            return zigzagOrder;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        int level = 0;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            zigzagOrder.add(new ArrayList<>());
            for(int i=0; i<levelSize; i++) {

                TreeNode curr = queue.poll();
                if(level%2==0) {
                    zigzagOrder.get(level).add(curr.val);
                } else {
                    zigzagOrder.get(level).add(0, curr.val);
                }
                
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }

            }
            level++;
        }
        return zigzagOrder;
    }
}