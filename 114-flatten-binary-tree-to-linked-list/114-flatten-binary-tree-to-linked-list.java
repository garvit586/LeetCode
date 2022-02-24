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
    public TreeNode helper(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        
        if(left != null){
            TreeNode temp = left;
            while(temp.right != null){
                temp = temp.right;
            }
            
            temp.right = right;
            root.left = null;
            root.right = left;
        }
        return root;
    }
    public void flatten(TreeNode root) {
        helper(root);
    }
}