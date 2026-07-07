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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        while(!dq.isEmpty()){

            int rightMost=0;
            int size = dq.size();
            for(int i=0;i<size;i++){
                TreeNode curr = dq.poll();
                rightMost = curr.val;
                if(curr.left != null){
                    dq.offer(curr.left);
                }
                if(curr.right != null){
                    dq.offer(curr.right);
                }

            }
            ans.add(rightMost);
        }
        return ans;
    }
}
