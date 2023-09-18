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

    // Ref: https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/solutions/2758013/level-depth/

    // Ref: https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/solutions/2757990/python-3-explanation-with-pictures-dfs/
    
    int [] depth = new int[100001];
    int [] level = new int[100001];
    int [] d1 = new int[100001];
    int [] d2 = new int[100001];


    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        traverse(root, 0);

        return getHeightForQuery(queries, n);
    }

    private int[] getHeightForQuery(int [] queries, int n) {
        int [] result = new int[n];
        for(int i=0; i<n; i++) {
            int nodeVal = queries[i];
            int nodeLevel = level[nodeVal];
            result[i] = nodeLevel + (d1[nodeLevel] == depth[nodeVal] ? d2[nodeLevel] : d1[nodeLevel]) -1;
        }

        return result;
    }

    public int traverse(TreeNode root, int nodeDepth) {
        if(root == null) {
            return 0;
        } 

        level[root.val] = nodeDepth;
        int leftHeight = traverse(root.left, nodeDepth+1);
        int rightHeight = traverse(root.right, nodeDepth+1);

        int height = Math.max(leftHeight, rightHeight) + 1;
        depth[root.val] = height;

        if(height > d1[nodeDepth]) {
            d2[nodeDepth] = d1[nodeDepth];
            d1[nodeDepth] = height;
        } else if(height > d2[nodeDepth]) {
            d2[nodeDepth] = height;
        }
        return height;
    }
}