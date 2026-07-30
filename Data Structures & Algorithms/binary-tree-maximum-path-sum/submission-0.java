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
    private int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMaxPath(root);
        return maxPath;
    }

    private int findMaxPath(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftMax = Math.max(0,findMaxPath(root.left));
        int rightMax = Math.max(0,findMaxPath(root.right));

        int currPath = leftMax+rightMax+root.val;
        maxPath = Math.max(maxPath,currPath);

        return root.val+Math.max(leftMax,rightMax);
    }
}
