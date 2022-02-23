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
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left != null){
            recoverTreeLeft(root,root.left);
        }
        if(root.right != null){
            recoverTreeRight(root,root.right);
        }
        recoverTree(root.left);
        recoverTree(root.right);
    }
    
    private void recoverTreeLeft(TreeNode root,TreeNode temp){
        if(root == null){
            return;
        }
        if(root.val < temp.val){
            int x = root.val;
            root.val = temp.val;
            temp.val = x;
            recoverTree(root);
            return ;
        }
        if(temp.left != null){
            recoverTreeLeft(root, temp.left);
        }
        if(temp.right != null){
            recoverTreeLeft(root,temp.right);
        }
    }
    
    private void recoverTreeRight(TreeNode root,TreeNode temp){
        if(root == null){
            return;
        }
        if(root.val > temp.val){
            int x = root.val;
            root.val = temp.val;
            temp.val = x;
            recoverTree(root);
            return ;
        }
        if(temp.left != null){
            recoverTreeRight(root, temp.left);
        }
        if(temp.right != null){
            recoverTreeRight(root,temp.right);
        }
    }
}