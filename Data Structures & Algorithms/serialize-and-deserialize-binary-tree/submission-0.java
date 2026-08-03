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

public class Codec {

    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        dfs(root,ans);
        return ans.toString(); 
    }
    private void dfs(TreeNode root,StringBuilder str){
        if(root == null){
            str.append("N,");
            return;
        }
        str.append(root.val);
        str.append(",");
        dfs(root.left,str);
        dfs(root.right,str);
    }

    // Decodes your encoded data to tree.
    int index = 0;
    public TreeNode deserialize(String data) {
        String[] charArray = data.split(",");
        return build(charArray);
    }

    private TreeNode build(String[] arr){
        if(arr[index].equals("N")){
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));
        index++;

        root.left = build(arr);
        root.right = build(arr);

        return root;

    }

}
