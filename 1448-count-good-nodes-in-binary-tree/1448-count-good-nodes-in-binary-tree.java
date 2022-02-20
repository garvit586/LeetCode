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
    int count =1;
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        if(root.left!= null){
            if(root.left.val >= root.val){
                count++;
            }else{
                root.left.val = root.val;
            }
        }
        if(root.right != null){
            if(root.right.val >= root.val){
                count++;
            }else{
                root.right.val = root.val;
            }
        }
        goodNodes(root.left);
        goodNodes(root.right);
        return count;
    }
}