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
    public TreeNode helper(int[] pre, int[] post, int preS, int preE,int postS ,int postE){
        if(preS > preE){
            return null;
        }
        TreeNode root = new TreeNode(pre[preS]);
        
        
        if(preS == preE){
            return root;
        }
        int rootIndex = -1;
        for(int i=postS;i<= postE;i++){
            if(pre[preS+1] == post[i]){
                rootIndex = i;
                break;
            }
        }
        int leftpostS = postS;
        int leftpostE = rootIndex;
        int leftPreS = preS+1;
        int leftPreE = rootIndex-postS+1+preS;
        int rightpostS = rootIndex+1;
        int rightpostE = postE-1;
        int rightPreS = leftPreE+1;
        int rightPreE = preE;
        root.left = helper(pre,post,leftPreS,leftPreE,leftpostS,leftpostE);
        root.right = helper(pre,post,rightPreS,rightPreE,rightpostS,rightpostE);
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder,postorder,0,preorder.length-1,0,postorder.length-1);
    }
}