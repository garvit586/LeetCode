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
    public int getPath(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        int ans = 0;
        if(root.val == targetSum){
            ans++;
        }
        return ans + getPath(root.left,targetSum-root.val)+getPath(root.right,targetSum-root.val);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        // pathSum(root.left,targetSum);
        // pathSum(root.right,targetSum);
        return getPath(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }
}