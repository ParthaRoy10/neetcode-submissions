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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q == null){
            return false;
        }
        else if( q != null && p==null){
            return false;
        }
        else if(p == null && q == null){
            return true;
        }

        if(p.val != q.val){
            return false;
        }
        boolean isLeftSimiler=isSameTree(p.left,q.left);
        boolean isRightSimiler=isSameTree(p.right,q.right);

        if(isLeftSimiler == false || isRightSimiler==false){
            return false;
        }
        return true;
    }
}
