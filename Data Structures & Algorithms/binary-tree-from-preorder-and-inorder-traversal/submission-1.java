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
    private HashMap<Integer,Integer> mapp = new HashMap<>();
    private int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            mapp.put(inorder[i],i);
        }

        return build(preorder,0,preorder.length-1);
    }

    private TreeNode build(int[] preorder,int left,int right){
        if(left > right){
            return null;
        }

        int val = preorder[preIndex++];
        TreeNode tempNode = new TreeNode(val);
        int mid = mapp.get(val);

        tempNode.left = build(preorder,left,mid-1);
        tempNode.right = build(preorder,mid+1,right);
        
        return tempNode;
    }
}
