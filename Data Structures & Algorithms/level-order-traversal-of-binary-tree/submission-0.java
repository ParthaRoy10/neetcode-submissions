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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Deque<TreeNode> dq = new ArrayDeque<>();

        dq.offerLast(root);

        while(!dq.isEmpty()){
            List<Integer> li = new ArrayList<>();
            int size = dq.size();

            for(int i=0;i<size;i++){
                TreeNode curr = dq.pollFirst();
                if(curr.left !=null){
                    dq.offerLast(curr.left);
                }
                if(curr.right != null){
                    dq.offerLast(curr.right);
                }
                li.add(curr.val);
            }
            ans.add(li);
        }
        return ans;

    }
}
