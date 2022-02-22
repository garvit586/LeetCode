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
    public TreeNode buildTreeHelper(int[] in, int[] pre, int inS, int inE,int preS, int preE){
        if(inS > inE){
            return null;
        }
        TreeNode root = new TreeNode(pre[preS]);
        int rootIndex = -1;
        for(int i=inS;i<=inE;i++){
            if(in[i] == pre[preS]){
                rootIndex = i;
                break;
            }
        }
        if(rootIndex == -1){
            return null;
        }
        int leftInS = inS;
        int leftInE = rootIndex-1;
        int leftPreS = preS+1;
        int leftPreE = leftInE-leftInS+leftPreS;
        int rightInS = rootIndex+1;
        int rightInE = inE;
        int rightPreS = leftPreE+1;
        int rightPreE = preE;
        root.left = buildTreeHelper(in,pre,leftInS,leftInE,leftPreS,leftPreE);
        root.right = buildTreeHelper(in,pre,rightInS,rightInE,rightPreS,rightPreE);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(inorder,preorder,0,inorder.length-1,0,preorder.length-1);
    }
}