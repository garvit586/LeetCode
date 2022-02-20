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
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        int difference = targetSum - root.val;
        if(difference == 0 && root.left == null && root.right == null){
            return true;
        }
        if(root.left != null){
            if(hasPathSum(root.left,difference)){
                return true;
            }
        }
        if(root.right != null){
            if(hasPathSum(root.right, difference)){
                return true;
            }
        }
        return false;
    }
}